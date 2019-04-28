package com.github.core.controller;

import com.github.core.domain.User;
import com.github.core.domain.UserInfo;
import com.github.core.domain.UserRole;
import com.github.core.pojo.Result;
import com.github.core.pojo.ResultCode;
import com.github.core.service.UserInfoService;
import com.github.core.service.UserRoleService;
import com.github.core.service.UserService;
import com.github.core.util.Base64UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TonyTonyChopper
 * @version 1.0
 */
@RestController
public class SystemController {

    private UserService userService;

    private UserInfoService userInfoService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserRoleService userRoleService;

    @Autowired
    public SystemController(UserService userService, UserInfoService userInfoService,
                            BCryptPasswordEncoder bCryptPasswordEncoder, UserRoleService userRoleService) {
        this.userService = userService;
        this.userInfoService = userInfoService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRoleService = userRoleService;
    }

    @PostMapping("signUp")
    public Result signUp(@RequestBody UserInfo userInfo) {
        User user = new User();
        UserRole userRole = new UserRole();
        user.setEnabled(true);
        String userId = Base64UUIDUtils.randomID();
        user.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        user.setUserId(userId);
        userInfo.setUserId(userId);
        userRole.setUserId(userId);
        userRole.setAuthority("ROLE_USER");
        int i = userService.signUp(user);
        int j = userInfoService.signUp(userInfo);
        int k = userRoleService.insert(userRole);
        if (i > 0 && j > 0 && k > 0) {
            Result result = new Result();
            result.setResultCode(ResultCode.OK);
            result.setMsg("注册成功！");
            return result;
        } else {
            Result result = new Result();
            result.setMsg("注册失败！");
            return result;
        }
    }
}
