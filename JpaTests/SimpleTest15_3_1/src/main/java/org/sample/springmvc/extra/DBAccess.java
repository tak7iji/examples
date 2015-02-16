package org.sample.springmvc.extra;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import org.sample.mybatis.OrderLine;
import org.sample.mybatis.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DBAccess {
    @Autowired
    SqlMapper sqlMapper;
    
    // UserTransaction版
    public List<OrderLine> dbAccess() throws Throwable {
        JndiTemplate jndiTemplate = new JndiTemplate();
        UserTransaction uTx = jndiTemplate.lookup("java:comp/UserTransaction", UserTransaction.class);
        
        List<OrderLine> list = null;
        try {
            uTx.begin();
            
            list = sqlMapper.findAll(Collections.singleton(1L));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            uTx.rollback();
        }
        return list;
    }
}
