package com.github.util.generator.mapper;

import com.github.util.generator.domain.SysAuthorities;

public interface SysAuthoritiesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAuthorities record);

    int insertSelective(SysAuthorities record);

    SysAuthorities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAuthorities record);

    int updateByPrimaryKey(SysAuthorities record);
}