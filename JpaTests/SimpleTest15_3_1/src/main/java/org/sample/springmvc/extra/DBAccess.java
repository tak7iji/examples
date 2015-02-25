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
import org.springframework.stereotype.Service;

@Service
public class DBAccess {
    @Autowired
    SqlMapper sqlMapper;
    
    // UserTransaction版
    public List<OrderLine> dbAccess(int type) throws Throwable {
        JndiTemplate jndiTemplate = new JndiTemplate();
        UserTransaction uTx = jndiTemplate.lookup("java:comp/UserTransaction", UserTransaction.class);
        
        List<OrderLine> list = null;
        try {
            uTx.begin();

            switch(type) {
            case 1:
                System.out.println("Call findAll");
                list = sqlMapper.findAll(Collections.singleton(1L));
                break;
            case 2:
                System.out.println("Call findById");
                list = sqlMapper.findById(1L);
                break;
            default:
                System.out.println("Call selectOrders");
                list = sqlMapper.selectOrders(1);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            uTx.rollback();
        }
        return list;
    }
}
