package com.github.core.service.impl;

import com.github.core.domain.User;
import com.github.core.domain.UserInfo;
import com.github.core.mapper.UserInfoMapper;
import com.github.core.mapper.UserMapper;
import com.github.core.pojo.Result;
import com.github.core.pojo.ResultCode;
import com.github.core.service.UserInfoService;
import com.github.core.util.Base64UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
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

    private final UserMapper userMapper;

    @Autowired
    public UserInfoServiceImpl(UserInfoMapper userInfoMapper, UserMapper userMapper) {
        this.userInfoMapper = userInfoMapper;
        this.userMapper = userMapper;
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
    public Result signOn(UserInfo userInfo) {
        UserInfo userInfo1 = userInfoMapper.signOn(userInfo);
        if (userInfo1 == null)
            return Result.failure(ResultCode.FORBIDDEN);
        else
            return Result.success(userInfo1);
    }

    @Override
    public Result signUp(UserInfo userInfo) {
        User user = new User();
        user.setEnabled(true);
        String userId = Base64UUIDUtils.randomID();
        userInfo.setUserId(userId);
        BeanUtils.copyProperties(userInfo, user);
        userInfo.setUserName("APP用户" + userId);
        userInfo.setGender(true);
        int insert = userMapper.insert(user);
        int signUp = 0;
        if (insert == 1) {
            signUp = userInfoMapper.insert(userInfo);
        }
        if (insert == 1 && signUp == 1) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.FORBIDDEN);
        }
    }

	@Override
	public UserInfo getUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.getUserInfo(userInfo);
	}
}
