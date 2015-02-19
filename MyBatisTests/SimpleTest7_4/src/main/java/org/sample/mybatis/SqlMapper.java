package org.sample.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SqlMapper {
    public List<OrderLine> selectOrders1(@Param("ID") int id);
    public List<OrderLine> selectOrders2(@Param("ID") int id);
}
