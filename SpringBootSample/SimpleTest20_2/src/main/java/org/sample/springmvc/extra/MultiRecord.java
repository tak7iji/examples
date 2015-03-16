package org.sample.springmvc.extra;

import java.util.Collections;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@WebService
public class MultiRecord {
    @Autowired DBAccess dbAccess;
    
    @WebMethod
    public List<TestTable> execute() throws Exception {
        
        try {
            return dbAccess.dbAccess();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        
        return Collections.EMPTY_LIST;
    }

}
