package org.sample.springmvc.extra;

import java.util.List;

import javax.transaction.UserTransaction;

import org.sample.mybatis.CustomerTable;
import org.sample.mybatis.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Service;

@Service
public class DBAccess {
    @Autowired SqlMapper sqlMapper;

    // UserTransaction版
    public List<CustomerTable> dbAccess() throws Throwable {
        JndiTemplate jndiTemplate = new JndiTemplate();
        UserTransaction uTx = jndiTemplate.lookup("java:comp/UserTransaction", UserTransaction.class);
        
        List<CustomerTable> list = null;
        try {
            uTx.begin();
            
            System.out.println("From Autowired: "+sqlMapper);
             list = sqlMapper.selectTestTables(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            uTx.rollback();
        }
        return list;
    }
}
