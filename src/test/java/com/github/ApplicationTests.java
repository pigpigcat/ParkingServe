package com.github;

import com.alibaba.fastjson.JSON;
import com.github.core.domain.UserInfo;
import com.github.core.pojo.Result;
import com.github.core.service.UserInfoService;
import com.github.pagehelper.PageInfo;
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

