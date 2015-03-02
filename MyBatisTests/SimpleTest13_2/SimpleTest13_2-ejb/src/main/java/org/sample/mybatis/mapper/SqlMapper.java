package org.sample.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sample.mybatis.entity.TestTable;

public interface SqlMapper {
    public List<TestTable> selectTestTables(@Param("id") int id, @Param("LIMIT_ID") String limitId, @Param("name") String name);

    public int insertTestTable(@Param("id") int id, @Param("name") String name, @Param("address") String address);

}
