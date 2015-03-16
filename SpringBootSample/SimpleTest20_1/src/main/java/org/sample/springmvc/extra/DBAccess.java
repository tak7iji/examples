package org.sample.springmvc.extra;

import java.util.Collections;
import java.util.List;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

import org.sample.mybatis.SqlMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.JtaTransactionManager;

@Service
public class DBAccess {
    @Autowired SqlMapper sqlMapper;
    @Autowired JtaTransactionManager transactionManager;

    public List<TestTable> dbAccess() throws IllegalStateException, SecurityException, SystemException {
        UserTransaction utx = transactionManager.getUserTransaction();
        
        try {
            utx.begin();
            
            System.out.println("From Autowired: "+sqlMapper);
            sqlMapper.insertTestTable(1, "name", "address");
               
            List<TestTable> list = sqlMapper.selectTestTables(1, "false", "a");
            return list;
        } catch (Exception ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        } finally {
            utx.rollback();
        }
        return Collections.EMPTY_LIST;
    }
}
