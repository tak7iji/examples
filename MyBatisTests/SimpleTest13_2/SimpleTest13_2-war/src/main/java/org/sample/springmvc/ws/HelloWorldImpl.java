package org.sample.springmvc.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.sample.springmvc.dto.TestTableDto;
import org.sample.springmvc.api.DBAccess;
import org.sample.springmvc.extra.ObjectBeanFactory;
import org.springframework.web.context.ContextLoader;

@WebService
public class HelloWorldImpl {
    private ObjectBeanFactory factory = new ObjectBeanFactory();

    @WebMethod
    public List<TestTableDto> sayHi() throws Throwable {
        System.out.println("ClassLoader: "+ContextLoader.class.getClassLoader());
        DBAccess dbAccess = factory.getBean();
        return dbAccess.dbAccess();
    }
    

}