package com.github.core.service;

import com.github.pagehelper.PageInfo;
import com.github.core.domain.UserInfo;

/**
 * @author wulitech
 */
public interface UserInfoService {

    PageInfo<UserInfo> queryAll();

    UserInfo getUserByName(String userName);

    /**
     * 登录
     *
     * @param userInfo
     * @return
     */
    int signOn(UserInfo userInfo);

    /**
     * 注册
     *
     * @param userInfo
     * @return
     */
    int signUp(UserInfo userInfo);
}
