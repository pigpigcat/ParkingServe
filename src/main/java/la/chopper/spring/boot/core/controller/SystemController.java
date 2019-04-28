package la.chopper.spring.boot.core.controller;

import la.chopper.spring.boot.core.domain.UserRole;
import la.chopper.spring.boot.core.pojo.Result;
import la.chopper.spring.boot.core.pojo.ResultCode;
import la.chopper.spring.boot.core.domain.User;
import la.chopper.spring.boot.core.domain.UserInfo;
import la.chopper.spring.boot.core.service.UserInfoService;
import la.chopper.spring.boot.core.service.UserRoleService;
import la.chopper.spring.boot.core.service.UserService;
import la.chopper.spring.boot.core.util.Base64UUIDUtils;
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
