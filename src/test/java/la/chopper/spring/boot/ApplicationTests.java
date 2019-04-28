package la.chopper.spring.boot;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import la.chopper.spring.boot.core.pojo.Result;
import la.chopper.spring.boot.core.domain.UserInfo;
import la.chopper.spring.boot.core.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void contextLoads() {

    }

    @Test
    public void PageHelperTest() {
        PageInfo<UserInfo> userInfoPageInfo = userInfoService.queryAll();
        logger.info(JSON.toJSONString(new Result(userInfoPageInfo)));
    }

}

