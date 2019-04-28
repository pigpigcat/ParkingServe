package la.chopper.spring.boot.core.mapper;

import la.chopper.spring.boot.core.domain.User;

/**
 * @author TonyTonyChopper
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserId(String userId);
}