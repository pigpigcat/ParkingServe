package la.chopper.spring.boot.generator.mapper;

import la.chopper.spring.boot.generator.domain.SysUserInfo;

public interface SysUserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserInfo record);

    int insertSelective(SysUserInfo record);

    SysUserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);
}