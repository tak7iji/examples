package org.sample.mybatis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlMapper extends JpaRepository<OrderLine, Long> {
    public List<OrderLine> findById(Long id);
}
