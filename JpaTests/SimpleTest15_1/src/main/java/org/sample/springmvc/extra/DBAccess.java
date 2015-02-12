package org.sample.springmvc.extra;

import java.util.List;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import org.sample.springmvc.entity.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class DBAccess extends SpringBeanAutowiringSupport {
    @Autowired
    EntityManager em;
    
    @Autowired
    UserTransaction uTx;
    
    // UserTransaction版
    public List<TestTable> dbAccess() throws Throwable {
       
        List<TestTable> list = null;
        try {
            uTx.begin();
            Query query = em.createQuery("From TestTable"); 
            list = query.getResultList();
            
        } catch (Exception e) {
            uTx.rollback();
            e.printStackTrace();
        } finally {
            uTx.commit();
        }
        return list;
    }
}
