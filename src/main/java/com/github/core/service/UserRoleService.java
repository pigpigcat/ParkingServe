package com.github.core.service;

import com.github.core.domain.UserRole;

import java.util.List;

/**
 * @author wulitech
 */
public interface UserRoleService {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<UserRole> findRolesByUserId(String userId);
}
