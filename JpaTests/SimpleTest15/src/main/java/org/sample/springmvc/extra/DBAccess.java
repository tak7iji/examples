package org.sample.springmvc.extra;

import java.util.List;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import org.sample.springmvc.entity.TestTable;

public class DBAccess {
    
    // UserTransaction版
    public List<TestTable> dbAccess() throws Throwable {

        InitialContext ic = new InitialContext();
        UserTransaction uTx = (UserTransaction) ic.lookup("java:comp/UserTransaction");
        EntityManager em = (EntityManager) ic.lookup("java:comp/env/persistence/em");
        
        List<TestTable> list = null;
        try {
            uTx.begin();
            Query query = em.createQuery("From TestTable"); 
            list = query.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            uTx.rollback();
        }
        return list;
    }
}
