package com.github.core.mapper;

import com.github.core.domain.UserInfo;

import java.util.List;

/**
 * @author wulitech
 * @version 1.0
 */
public interface UserInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 查询所有
     *
     * @return
     */
    List<UserInfo> queryAll();

    UserInfo getUserByName(String userName);
}
