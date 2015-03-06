package org.sample.springmvc.extra;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.sample.mybatis.TableMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DBAccess {
    @PostConstruct
    public void init() {
        System.out.println("Construct: "+this);
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("Destroy: "+this);
    }
    
    @Autowired private TableMapper sqlMapper;
    @Autowired private PlatformTransactionManager transactionManager;
    
    public List<TestTable> dbAccess() {
        return new TransactionTemplate(transactionManager).execute(new TransactionCallback<List<TestTable>>() {
            public List<TestTable> doInTransaction(TransactionStatus status) {
                System.out.println("From Autowired: "+sqlMapper);
                sqlMapper.insertTestTable(1, "name", "address");
                
                List<TestTable> list = sqlMapper.selectTestTables(5, "true", "a");
                status.setRollbackOnly();
                return list;
            }
        });
    }
}
