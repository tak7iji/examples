package org.sample.springmvc.extra;

import java.util.Collections;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;
import org.sample.jboss.jms.MessageSender;
import org.sample.mybatis.SqlMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.JtaTransactionManager;

@Service
public class DBAccess {
    private Logger logger = Logger.getLogger(DBAccess.class);
    @Autowired SqlMapper sqlMapper;
    @Autowired JtaTransactionManager transactionManager;
    @Autowired MessageSender messageSender;

    public List<TestTable> dbAccess(int type) throws Exception {
        UserTransaction utx = transactionManager.getUserTransaction();
        
        try {
            utx.begin();
            
            logger.info("From Autowired: "+sqlMapper);
            sqlMapper.insertTestTable(1, "name", "address");
               
            List<TestTable> list = sqlMapper.selectTestTables(1, "false", "a");
            messageSender.simpleSend();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (type == 0)
                utx.commit();
            else
                utx.rollback();
        }
        return Collections.EMPTY_LIST;
    }
}
