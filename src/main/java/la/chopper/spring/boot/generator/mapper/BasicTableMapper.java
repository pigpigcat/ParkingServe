package la.chopper.spring.boot.generator.mapper;

import la.chopper.spring.boot.generator.domain.BasicTable;

public interface BasicTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasicTable record);

    int insertSelective(BasicTable record);

    BasicTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasicTable record);

    int updateByPrimaryKey(BasicTable record);
}