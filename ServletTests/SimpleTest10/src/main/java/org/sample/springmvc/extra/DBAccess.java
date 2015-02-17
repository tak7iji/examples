package org.sample.springmvc.extra;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.sample.mybatis.TableMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Service(value="dbAccess")
public class DBAccess implements InitializingBean, DisposableBean {
    @Autowired private TableMapper sqlMapper;
    @Autowired private PlatformTransactionManager transactionManager;
    
    public DBAccess() {
        System.out.println("Constructor: "+this);
    }
    
    @PostConstruct
    public void start() {
        System.out.println("Start: "+this);
    }
    
    @PreDestroy
    public void stop() {
        System.out.println("Stop: "+this);
    }
    
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
    
    public void startBean() {
        System.out.println("Start DBAccess: "+this);
    }
    
    public void stopBean() {
        System.out.println("Stop DBAccess: "+this);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy: "+this);
        
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet: "+this);
        
    }
    
    public void init() {
        System.out.println("init: "+this);
        
    }

}
