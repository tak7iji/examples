package org.sample.springmvc.extra;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.sample.mybatis.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService
public class MultiRecord extends SpringBeanAutowiringSupport {
    @Autowired DBAccess dbAccess;
    
    @WebMethod
    public List<OrderLine> execute(int type) throws Exception {
        
        try {
            return dbAccess.dbAccess(type);
        } catch (Throwable t) {
            System.out.println("Exception occured!");
            t.printStackTrace();
        }
        
        return null;
    }

}
