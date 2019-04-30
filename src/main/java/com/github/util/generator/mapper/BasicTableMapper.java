package com.github.util.generator.mapper;

import com.github.util.generator.domain.BasicTable;

public interface BasicTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasicTable record);

    int insertSelective(BasicTable record);

    BasicTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasicTable record);

    int updateByPrimaryKey(BasicTable record);
}