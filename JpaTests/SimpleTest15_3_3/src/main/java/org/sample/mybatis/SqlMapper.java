package org.sample.mybatis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SqlMapper extends JpaRepository<OrderLine, Long> {
    
    @Query("select o from OrderLine o where o.id = :ID")
    public List<OrderLine> selectOrders(@Param("ID") long id);
}
