package la.chopper.spring.boot.core.service.impl;

import la.chopper.spring.boot.core.domain.UserInfo;
import la.chopper.spring.boot.core.domain.UserRole;
import la.chopper.spring.boot.core.service.UserInfoService;
import la.chopper.spring.boot.core.service.UserRoleService;
import la.chopper.spring.boot.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * 自定义用户验证类
 *
 * @author TonyTonyChopper
 * @version 1.0
 */
@Component("customUserDetailServiceImpl")
public class CustomUserDetailServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private UserInfoService userInfoService;

    private UserRoleService userRoleService;

    private UserService userService;

    @Autowired
    public CustomUserDetailServiceImpl(UserInfoService userInfoService, UserRoleService userRoleService, UserService userService) {
        this.userInfoService = userInfoService;
        this.userRoleService = userRoleService;
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 获取用户信息
        UserInfo userInfo = userInfoService.getUserByName(username);
        List<UserRole> userRoles = userRoleService.findRolesByUserId(userInfo.getUserId());
        return changeToUsers(userInfo, userRoles,userService.selectByUserId(userInfo.getUserId()).getPassword());
    }

    private UserDetails changeToUsers(UserInfo userInfo, List<UserRole> userRoles,String password) {
        // 权限列表
        List<GrantedAuthority> authorityList = new ArrayList<>();
        // 赋予查询到的角色
        for (UserRole userRole : userRoles) {
            GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAuthority());
            authorityList.add(authority);
        }
        // 创建UserDetails 对象，设置用户名、密码和权限
        return new User(userInfo.getUserName(), password, authorityList);
    }

}
