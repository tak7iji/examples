package org.sample.springmvc.extra;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.UserTransaction;

import org.sample.mybatis.entity.TestTable;
import org.sample.mybatis.mapper.SqlMapper;
import org.sample.springmvc.api.DBAccess;
import org.sample.springmvc.dto.TestTableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Service;

@Service("dbAccess")
public class DBAccessImpl implements DBAccess {
    @Autowired SqlMapper sqlMapper;
    
    // UserTransaction版
    public List<TestTableDto> dbAccess() throws Throwable {

        JndiTemplate jndiTemplate = new JndiTemplate();
        UserTransaction uTx = jndiTemplate.lookup("java:comp/UserTransaction", UserTransaction.class);
        
        List<TestTable> list = null;
        List<TestTableDto> dto = null;
        try {
            uTx.begin();
            
            System.out.println("From Autowired: "+sqlMapper);
            sqlMapper.insertTestTable(1, "name", "address");
            
             list = sqlMapper.selectTestTables(1, "false", "a");
             dto = new ArrayList<TestTableDto>(list.size());
             for(TestTable tt: list) {
                 TestTableDto ttDto = new TestTableDto();
                 ttDto.setId(tt.getId());
                 ttDto.setName(tt.getName());
                 ttDto.setAddress(tt.getAddress());
                 dto.add(ttDto);
             }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            uTx.rollback();
        }
        return dto;
    }
}
