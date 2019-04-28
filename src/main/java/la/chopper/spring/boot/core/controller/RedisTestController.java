package la.chopper.spring.boot.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * redis generator
 *
 * @author TonyTonyChopper
 * @version 1.0
 */
@RestController
@RequestMapping("redis")
public class RedisTestController {

    private RedisTemplate<Object,Object> redisTemplate;

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisTestController(RedisTemplate<Object,Object> redisTemplate, StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = redisTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @RequestMapping("stringAndHash")
    @ResponseBody
    public Map<String, Object> testStringAndHash() {
        redisTemplate.opsForValue().set("key1", "value1");
        // 注意这里使用了JDK 的序列化器,所以Redis保存时不是整数,不能运算
        redisTemplate.opsForValue().set("int_key", "1");
        stringRedisTemplate.opsForValue().set("int", "l");
        // 使用运算
        stringRedisTemplate.opsForValue().increment("int", 1);
        // 获取底层Jedis连接
        Jedis jedis = (Jedis) Objects.requireNonNull(stringRedisTemplate.getConnectionFactory())
                .getConnection().getNativeConnection();
        // 减l操作,这个命令RedisTemplate不支持,所以先获取底层的连接再操作
        jedis.decr("int");
        Map<String, String> hash = new HashMap<>(16);
        hash.put("field1", "value1");
        hash.put("field2", "value2");
        // 存入一个散列数据类型
        stringRedisTemplate.opsForHash().putAll("hash", hash);
        // 新增一个字段
        stringRedisTemplate.opsForHash().put("hash", "field3", "value3");
        // 绑定散列操作的key,这样可以连续对同一个散列数据类型进行操作
        BoundHashOperations hashOps = stringRedisTemplate.boundHashOps("hash");
        // 删除两个字段
        hashOps.delete("field1", "field2");
        // 新增一个字段
        hashOps.put("filed4", "values");
        Map<String, Object> map = new HashMap<>(16);
        map.put("success", true);
        return map;
    }

    @RequestMapping("/set")
    @ResponseBody
    public Map<String, Object> testSet() {
        // 请注意:这里v1重复两次,因为集合不允许重复,所以只是插入5个成员到集合中
        stringRedisTemplate.opsForSet().add(" set1",
                " v1", "v1", "v2", "v3", "v4", "v5");
        stringRedisTemplate.opsForSet().add("set2", "v2", "v4", "v6", "v8");
        // 绑定set1集合操作
        BoundSetOperations<String,String> setOps = stringRedisTemplate.boundSetOps("set l ");
        // 增加两个元素
        setOps.add("v6", "v7");
        // 删除两个元素
        setOps.remove("v1", "v7");
        // 返回所有元素
        Set set1 = setOps.members();
        //求成员数
        setOps.size();
        //求交集
        setOps.intersect("set2");
        //求交集，并且用新集合inter保存
        setOps.intersectAndStore("set2", "inter");
        //求差集
        setOps.diff("set2");
        //求差集，并且用新集合diff保存
        setOps.diffAndStore("set2", "diff");
        //求并集
        setOps.union("set2");
        //求并集，并且用新集合union保存
        setOps.unionAndStore("set2", "union");
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("zset")
    @ResponseBody
    public Map<String, Object> testZset() {
        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            // 分数
            double score = i * 0.1;
            // 创建一个TypedTuple对象,存入值和分数
            ZSetOperations.TypedTuple<String> typedTuple
                    = new DefaultTypedTuple<>("value" + i, score);
            typedTupleSet.add(typedTuple);
        }
        // 往有序集合插入元素
        stringRedisTemplate.opsForZSet().add("zset1", typedTupleSet);
        // 绑定zset1有序集合操作
        BoundZSetOperations<String, String> zsetOps
                = stringRedisTemplate.boundZSetOps("zset1");
        // 增加一个元素
        zsetOps.add("value10", 0.26);
        zsetOps.range(1, 6);
        // 按分数排序获取有序集合
        zsetOps.rangeByScore(0.2, 0.6);
        // 定义值范围
        RedisZSetCommands.Range range = new RedisZSetCommands.Range();
        // 大于value3
        range.gt("value3");
        // range.gte("value3");// 大于等于value3
        // range.lt("value8");// 小于value8
        // 小于等于value8
        range.lte("value8");
        // 按值排序，请注意这个排序是按字符串排序
        Set<String> setLex = zsetOps.rangeByLex(range);
        // 删除元素
        zsetOps.remove("value9", "value2");
        // 求分数
        zsetOps.score("value8");
        // 在下标区间下,按分数排序,同时返回value和score
        zsetOps.rangeWithScores(1, 6);
        // 在分数区间下,按分数排序,同时返回value和score
        zsetOps.rangeByScoreWithScores(1, 6);
        // 按从大到小排序
        zsetOps.reverseRange(2, 8);
        Map<String, Object> map = new HashMap<>(16);
        map.put("success", true);
        return map;
    }

    /**
     * 使用Red is 流水线测试性能
     *
     * @return
     */
    @RequestMapping("pipeline")
    @ResponseBody
    public Map<String, Object> testPipeline() {
        Long start = System.currentTimeMillis();
        redisTemplate.executePipelined(new SessionCallback<Object>() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                for (int i = 1; i <= 100000; i++) {
                    operations.opsForValue().set("pipeline" + i, "value" + i);
                    String value = (String) operations.opsForValue().get("pipeline" + i);
                    if (i == 100000) {
                        System.out.println("命令只是进入队列，所以值为空【" + value + "】");
                    }
                }
                return null;
            }
        });
        Long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + " 毫秒。");
        Map<String, Object> map = new HashMap<>(16);
        map.put(" success ", true);
        return map;
    }
}