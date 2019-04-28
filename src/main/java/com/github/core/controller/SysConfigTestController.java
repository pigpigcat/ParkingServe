package com.github.core.controller;

import com.github.domain.DemoDomain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试
 *
 * @author wulitech
 * @version 1.0
 */
@RestController
public class SysConfigTestController {

    @GetMapping("soraka/needToLogin")
    public DemoDomain needToLogin() {
        DemoDomain demoDomain = new DemoDomain();
        demoDomain.setId(1);
        demoDomain.setRemarks("需要登录");
        demoDomain.setCreateTime(new Date());
        return demoDomain;
    }

    @GetMapping("anonymousAccess")
    public DemoDomain anonymousAccess() {
        DemoDomain demoDomain = new DemoDomain();
        demoDomain.setId(2);
        demoDomain.setRemarks("匿名访问");
        demoDomain.setCreateTime(new Date());
        return demoDomain;
    }

}
