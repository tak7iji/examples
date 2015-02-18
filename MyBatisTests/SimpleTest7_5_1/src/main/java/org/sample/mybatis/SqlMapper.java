package org.sample.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SqlMapper {
    public List<CustomerTable> selectTestTables(@Param("c_id") int c_id);
}
