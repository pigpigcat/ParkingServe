package com.github.core.service;


import com.github.core.domain.User;

/**
 * @author wulitech
 */
public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserId(String userId);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    int signUp(User user);
}
