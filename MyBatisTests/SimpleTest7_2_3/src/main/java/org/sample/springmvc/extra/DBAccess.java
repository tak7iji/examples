package org.sample.springmvc.extra;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.sample.mybatis.TableMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
public class DBAccess {
    @Autowired private TableMapper sqlMapper;
    @Autowired private PlatformTransactionManager transactionManager;
    
    // TransactionTemplate版
    public List<TestTable> dbAccess() {
        return new TransactionTemplate(transactionManager).execute(status -> {
            System.out.println("From Autowired: "+sqlMapper);
            sqlMapper.insertTestTable(1, "name", "address");
            
            List<TestTable> list = sqlMapper.selectTestTables(1, "false", "a");
            status.setRollbackOnly();
            return list;
        });
    }
}
