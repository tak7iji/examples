package org.sample.springmvc.extra;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import org.sample.mybatis.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DBAccess {
    @Autowired
    EntityManagerFactory emf;
    
    // UserTransaction版
    public List<OrderLine> dbAccess() throws Throwable {
        JndiTemplate jndiTemplate = new JndiTemplate();
        UserTransaction uTx = jndiTemplate.lookup("java:comp/UserTransaction", UserTransaction.class);
        
        List<OrderLine> list = null;
        try {
            uTx.begin();
            
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("select o from OrderLine o where o.id = :ID");
            query.setParameter("ID", 1L);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            uTx.rollback();
        }
        return list;
    }
}
