package org.sample.springmvc.extra;

import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.sample.mybatis.TableMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Configurable
public class DBAccess {
    @Autowired private TableMapper sqlMapper;
    @Autowired private PlatformTransactionManager transactionManager;
    
    public List<TestTable> dbAccess() {
        System.out.println(this.getClass().getClassLoader());
        return new TransactionTemplate(transactionManager).execute(new TransactionCallback<List<TestTable>>() {
            public List<TestTable> doInTransaction(TransactionStatus status) {
                System.out.println("From Autowired: "+sqlMapper);
                sqlMapper.insertTestTable(1, "name", "address");
                
                List<TestTable> list = sqlMapper.selectTestTables(1, "false", "a");
                status.setRollbackOnly();
                return list;
            }
        });
    }
}
