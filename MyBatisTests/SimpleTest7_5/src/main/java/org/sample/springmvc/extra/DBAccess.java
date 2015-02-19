package org.sample.springmvc.extra;

import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.sample.mybatis.CustomerTable;
import org.sample.mybatis.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Service;

@Service
public class DBAccess {
    @Autowired SqlMapper sqlMapper;
    @Autowired SqlSessionFactory factory;

    // UserTransaction版
    public List<? extends CustomerTable> dbAccess(int type) throws Throwable {
        JndiTemplate jndiTemplate = new JndiTemplate();
        UserTransaction uTx = jndiTemplate.lookup("java:comp/UserTransaction", UserTransaction.class);
        
        List<? extends CustomerTable> list = null;
        try {
            uTx.begin();
            
            System.out.println("From Autowired: "+sqlMapper);
            Configuration config = factory.getConfiguration();
            switch(type) {
            case 1:
                config.setMapUnderscoreToCamelCase(false);
                list = sqlMapper.selectTestTables1(1);
                break;
            case 2:
                // CamelCaseを有効化
                config.setMapUnderscoreToCamelCase(true);
                list = sqlMapper.selectTestTables2(1);
                break;
            case 3:
                // CamelCaseを有効化
                config.setMapUnderscoreToCamelCase(true);
                list = sqlMapper.selectTestTables3(1);
                break;
            case 4:
                // CamelCaseを有効化
                config.setMapUnderscoreToCamelCase(true);
                list = sqlMapper.selectTestTables4(1);
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
