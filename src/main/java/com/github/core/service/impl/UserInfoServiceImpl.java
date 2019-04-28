package com.github.core.service.impl;

import com.github.core.domain.UserInfo;
import com.github.core.mapper.UserInfoMapper;
import com.github.core.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wulitech
 * @version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public PageInfo<UserInfo> queryAll() {
        //获取第x页，x条内容，默认查询总数count
        PageHelper.startPage(1, 15);
        List<UserInfo> userInfoList = userInfoMapper.queryAll();
        //用PageInfo对结果进行包装
        return new PageInfo<>(userInfoList);
    }

    @Override
    public UserInfo getUserByName(String userName) {
        return userInfoMapper.getUserByName(userName);
    }

    @Override
    public int signOn(UserInfo userInfo) {
        return 0;
    }

    @Override
    public int signUp(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);

    }
}
