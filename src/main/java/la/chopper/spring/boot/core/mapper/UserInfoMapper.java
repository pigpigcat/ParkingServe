package la.chopper.spring.boot.core.mapper;

import la.chopper.spring.boot.core.domain.UserInfo;

import java.util.List;

/**
 * @author TonyTonyChopper
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
