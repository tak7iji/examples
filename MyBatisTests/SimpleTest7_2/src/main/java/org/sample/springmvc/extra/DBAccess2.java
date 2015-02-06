package org.sample.springmvc.extra;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.sample.mybatis.SqlMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
// rollbackForでExceptionを指定すると、指定したExceptionが発生した場合にロールバックが行われる
// @Transactional(rollbackFor=Exception.class)
// @Transactionalが指定されている場合、transactionManagerを使用した明示的なトランザクション制御はできない。どちらかだけ使う
// @Transactional
public class DBAccess2 extends SqlSessionDaoSupport {
    @Autowired SqlSession sqlSession;
    @Autowired SqlMapper sqlMapper;
    @Autowired PlatformTransactionManager transactionManager;
    
    @Autowired
    public DBAccess2(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
    
    // TransactionTemplate版
    public List<TestTable> dbAccess() {
        return new TransactionTemplate(transactionManager).execute(status -> {
            System.out.println("From Autowired: "+sqlMapper);
            SqlMapper sqlMapper2 = sqlSession.getMapper(SqlMapper.class);
            System.out.println("From SqlSessionTemplate: "+sqlMapper2);
            SqlMapper sqlMapper3 = getSqlSession().getMapper(SqlMapper.class);
            System.out.println("From Support Class: "+sqlMapper3);
            sqlMapper3.insertTestTable(1, "name", "address");
            
            List<TestTable> list = sqlMapper.selectTestTables(1, "false", "a");
            status.setRollbackOnly();
            return list;
        });
    }
}
