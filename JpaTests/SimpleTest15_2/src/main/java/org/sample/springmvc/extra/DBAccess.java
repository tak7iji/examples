package org.sample.springmvc.extra;

import java.util.List;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import org.sample.springmvc.entity.TestTable;
import org.sample.springmvc.repository.TestTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class DBAccess extends SpringBeanAutowiringSupport {
    @Autowired
    UserTransaction uTx;
    
    @Autowired TestTableRepository repository;
    
    // UserTransaction版
    public List<TestTable> dbAccess() throws Throwable {
       
        List<TestTable> list = null;
        try {
            uTx.begin();
//            EntityManager em = emf.createEntityManager();
//            Query query = em.createQuery("From TestTable");
//            list = query.getResultList();
            list = repository.findAll();
        } catch (Exception e) {
            uTx.rollback();
            e.printStackTrace();
        } finally {
            uTx.commit();
        }
        return list;
    }
}
