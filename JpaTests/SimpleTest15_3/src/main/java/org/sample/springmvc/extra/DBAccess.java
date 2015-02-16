package org.sample.springmvc.extra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import org.sample.mybatis.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Service;

@Service
public class DBAccess {
    @PersistenceUnit
    EntityManagerFactory emFactory;
    
    // 同一クラスで複数のBeanが定義されている場合、Bean名で区別するか、もしくは@Beanがついたメソッド名で区別する
    // XMLでBeanを定義している場合は、<bean>のid属性で区別する
    @Autowired
    JndiTemplate jndiTemp;
    
    // UserTransaction版
    public List<OrderLine> dbAccess() throws Throwable {
        System.out.println("JndiTemplate: "+jndiTemp);
//        JndiTemplate jndiTemplate = new JndiTemplate();
        UserTransaction uTx = jndiTemp.lookup("java:comp/UserTransaction", UserTransaction.class);
//        EntityManagerFactory emFactory = jndiTemplate.lookup("java:/persistence/emf", EntityManagerFactory.class);
        
        List<OrderLine> list = null;
        uTx.begin();
        System.out.println(emFactory);
        EntityManager em = emFactory.createEntityManager();
        try {
            Query query = em.createQuery("select o from OrderLine o where o.id = :ID");
            query.setParameter("ID", 1L);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            uTx.commit();
        }
        return list;
    }
}
