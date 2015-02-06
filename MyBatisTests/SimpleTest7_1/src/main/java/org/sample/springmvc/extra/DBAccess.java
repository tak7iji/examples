package org.sample.springmvc.extra;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.sample.mybatis.SqlMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
// rollbackForでExceptionを指定すると、指定したExceptionが発生した場合にロールバックが行われる
// @Transactional(rollbackFor=Exception.class)
// @Transactionalが指定されている場合、transactionManagerを使用した明示的なトランザクション制御はできない。どちらかだけ使う
// @Transactional
public class DBAccess {
    @Autowired SqlSessionFactory sqlSessionFactory;
    @Autowired PlatformTransactionManager transactionManager;
    
    // PlatformTransactionManager直版
    public List<TestTable> _dbAccess() throws Exception {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            SqlSession session = sqlSessionFactory.openSession();
            System.out.println(session.getConfiguration().getDatabaseId());
            
            SqlMapper mapper = session.getMapper(SqlMapper.class);
            mapper.insertTestTable(1, "name", "address");
            List<TestTable> list = mapper.selectTestTables(1, "false", "a");
            return list;
        } finally {
            transactionManager.rollback(status);
        }
    }

    // TransactionTemplate版
    public List<TestTable> dbAccess() {
        return new TransactionTemplate(transactionManager).execute(status -> {
            SqlSession session = sqlSessionFactory.openSession();
            System.out.println(session.getConfiguration().getDatabaseId());
            
            SqlMapper mapper = session.getMapper(SqlMapper.class);
            mapper.insertTestTable(1, "name", "address");
            
            List<TestTable> list = mapper.selectTestTables(1, "false", "a");
            status.setRollbackOnly();
            return list;
        });
    }
}
