package la.chopper.spring.boot.core.service;

import la.chopper.spring.boot.core.domain.UserRole;

import java.util.List;

/**
 * @author TonyTonyChopper
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
