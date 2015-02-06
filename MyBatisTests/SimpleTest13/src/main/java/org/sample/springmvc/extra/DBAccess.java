package org.sample.springmvc.extra;

import java.util.List;

import javax.transaction.UserTransaction;

import org.sample.mybatis.SqlMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DBAccess {
    @Autowired SqlMapper sqlMapper;
    
    // UserTransaction版
    public List<TestTable> dbAccess() throws Throwable {

        JndiTemplate jndiTemplate = new JndiTemplate();
        UserTransaction uTx = jndiTemplate.lookup("java:comp/UserTransaction", UserTransaction.class);
        
        List<TestTable> list = null;
        try {
            uTx.begin();
            
            System.out.println("From Autowired: "+sqlMapper);
            sqlMapper.insertTestTable(1, "name", "address");
            
             list = sqlMapper.selectTestTables(1, "false", "a");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            uTx.rollback();
        }
        return list;
    }
}
