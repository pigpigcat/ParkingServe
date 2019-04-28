package la.chopper.spring.boot.core.service.impl;

import la.chopper.spring.boot.core.domain.UserRole;
import la.chopper.spring.boot.core.mapper.UserRoleMapper;
import la.chopper.spring.boot.core.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TonyTonyChopper
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleMapper userRoleMapper;

    @Autowired
    public UserRoleServiceImpl(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

    @Override
    public UserRole selectByPrimaryKey(Integer id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserRole record) {
        return userRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UserRole> findRolesByUserId(String userId) {
        return userRoleMapper.findRolesByUserId(userId);
    }
}
