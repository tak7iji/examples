package org.sample.springmvc.extra;

import java.util.List;

import org.sample.mybatis.TableMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class DBAccess {
    @Autowired private TableMapper sqlMapper;
    @Autowired private PlatformTransactionManager transactionManager;
    
    public List<TestTable> dbAccess() {
        return new TransactionTemplate(transactionManager).execute(new TransactionCallback<List<TestTable>>() {
            public List<TestTable> doInTransaction(TransactionStatus status) {
                System.out.println("From Autowired: "+sqlMapper);
                sqlMapper.insertTestTable(1, "name", "address");
                
                List<TestTable> list = sqlMapper.selectTestTables(5, "false", "a");
                status.setRollbackOnly();
                return list;
            }
        });
    }
}
