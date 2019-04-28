package la.chopper.spring.boot.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 配置redis
 *
 * @author TonyTonyChopper
 * @version 1.0
 */
@Configuration
@EnableConfigurationProperties(RedisDataSourceProperties.class)
public class RedisConfig {

    private RedisConnectionFactory redisConnectionFactory;

    private final RedisDataSourceProperties properties;

    @Autowired
    public RedisConfig(RedisDataSourceProperties properties) {
        this.properties = properties;
    }

    @Bean
    public RedisConnectionFactory customRedisConnectionFactory() {
        if (this.redisConnectionFactory != null) {
            return this.redisConnectionFactory;
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲数
        jedisPoolConfig.setMaxIdle(properties.getMaxIdle());
        // 最大连接数
        jedisPoolConfig.setMaxTotal(properties.getMaxTotal());
        // 最大等待毫秒数
        jedisPoolConfig.setMaxWaitMillis(properties.getMaxWaitMillis());
        // 创建Jedis连接工厂
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
        // 获取单机的Redis配置
        RedisStandaloneConfiguration standaloneConfiguration = jedisConnectionFactory.getStandaloneConfiguration();
        if (standaloneConfiguration == null) {
            throw new NullPointerException("RedisStandaloneConfiguration is null");
        }
        standaloneConfiguration.setHostName(properties.getHostName());
        standaloneConfiguration.setPort(properties.getPort());
        standaloneConfiguration.setPassword(properties.getPassword());
        this.redisConnectionFactory = jedisConnectionFactory;
        return redisConnectionFactory;
    }

    /**
     * 创建RedisTemplate
     *
     * @param redisConnectionFactory
     * @return RedisTemplate
     */
    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> initRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        // RedisTemplate会自动初始化StringRedisSerializer,所以这里直接获取
        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
        // 设置字符串序列化器，这样Spring就会把Redis的key当作字符串处理了
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
