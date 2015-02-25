package org.sample.springmvc.extra;

import java.util.List;

import org.sample.mybatis.SqlMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DBAccess {
    @Autowired SqlMapper sqlMapper;

    @Transactional
    public List<TestTable> dbAccess() throws Throwable {
        
        List<TestTable> list = null;
        try {
            System.out.println("From Autowired: "+sqlMapper);
            sqlMapper.insertTestTable(1, "name", "address");
            
             list = sqlMapper.selectTestTables(1, "false", "a");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
