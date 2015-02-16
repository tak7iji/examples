package org.sample.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SqlMapper {
    public List<OrderLine> selectOrders(@Param("ID") int id);
}
