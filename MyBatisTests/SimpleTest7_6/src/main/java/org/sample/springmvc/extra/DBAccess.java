package org.sample.springmvc.extra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.UserTransaction;

import org.sample.mybatis.CustomerTable;
import org.sample.mybatis.SqlMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Service;

@Service
public class DBAccess {
    @Autowired SqlMapper sqlMapper;

    // UserTransaction版
    public List<TestTable> dbAccess(int type) throws Throwable {
        JndiTemplate jndiTemplate = new JndiTemplate();
        UserTransaction uTx = jndiTemplate.lookup("java:comp/UserTransaction", UserTransaction.class);
        
        List<TestTable> list = null;
        try {
            uTx.begin();
            
            System.out.println("From Autowired: "+sqlMapper);
            sqlMapper.insertTestTable(1, "name", "address");
            
            switch(type) {
            case 1:
                System.out.println("Call selectTestTable1");
                list = sqlMapper.selectTestTables1(1, "false", "a");
                break;
            case 2:
                System.out.println("Call selectTestTable2");
                list = sqlMapper.selectTestTables2(1, "false", "a");
                break;
            case 3:
                System.out.println("Call selectTestTable3");
                list = sqlMapper.selectTestTables3(Arrays.asList(1, "a"), Arrays.asList("false"));
                break;
            case 4:
                System.out.println("Call selectTestTable4");
                list = sqlMapper.selectTestTables4(Arrays.asList(1, "false", "a"));
                break;
            case 5:
                System.out.println("Call selectTestTable5");
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", 1);
                map.put("limitId", "false");
                map.put("address", "a");
                list = sqlMapper.selectTestTables5(map);
                break;
            case 6:
                System.out.println("Call selectTestTable6");
                Map<String, Object> map1 = new HashMap<String, Object>();
                map1.put("id", 1);
                map1.put("address", "a");
                
                Map<String, Object> map2 = new HashMap<String, Object>();
                map2.put("id", 2);
                map2.put("limitId", "false");

                list = sqlMapper.selectTestTables6(map1, map2);
                break;
            case 7:
                System.out.println("Call selectTestTable7");
                Object[] objs = {1, "false", "a"};
                list = sqlMapper.selectTestTables7(objs);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            uTx.rollback();
        }
        return list;
    }
    
    public List<CustomerTable> dbAccess2() throws Throwable {
        JndiTemplate jndiTemplate = new JndiTemplate();
        UserTransaction uTx = jndiTemplate.lookup("java:comp/UserTransaction", UserTransaction.class);
        
        List<CustomerTable> list = null;
        try {
            uTx.begin();
            
            System.out.println("From Autowired: "+sqlMapper);
            System.out.println("Call selectTestTable8");
            list = sqlMapper.selectTestTables8(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            uTx.rollback();
        }
        return list;
    }

}
