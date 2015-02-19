package org.sample.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SqlMapper {
    public List<CustomerTable1> selectTestTables1(@Param("c_id") int c_id);
    public List<CustomerTable2> selectTestTables2(@Param("c_id") int c_id);
    public List<CustomerTable3> selectTestTables3(@Param("c_id") int c_id);
    public List<CustomerTable2> selectTestTables4(@Param("c_id") int c_id);
}
