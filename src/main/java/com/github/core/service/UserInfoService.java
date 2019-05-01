package com.github.core.service;

import com.github.core.pojo.Result;
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
    Result signOn(UserInfo userInfo);

    /**
     * 注册
     *
     * @param userInfo
     * @return
     */
    Result signUp(UserInfo userInfo);
}
