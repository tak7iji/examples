package org.sample.springmvc.extra;

import java.util.List;

import javax.transaction.UserTransaction;

import org.sample.mybatis.OrderLine;
import org.sample.mybatis.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DBAccess {
    @Autowired SqlMapper sqlMapper;

    // UserTransaction版
    public List<OrderLine> dbAccess(int type) throws Throwable {
        JndiTemplate jndiTemplate = new JndiTemplate();
        UserTransaction uTx = jndiTemplate.lookup("java:comp/UserTransaction", UserTransaction.class);
        
        List<OrderLine> list = null;
        try {
            uTx.begin();
            
            switch(type) {
            case 1:
                System.out.println("Call selectOrders1");
                list = sqlMapper.selectOrders1(1);
                break;
            case 2:
                System.out.println("Call selectOrders2");
                list = sqlMapper.selectOrders2(1);
                break;
            default:
                System.out.println("Call selectOrders3");
                list = sqlMapper.selectOrders3(1);
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
