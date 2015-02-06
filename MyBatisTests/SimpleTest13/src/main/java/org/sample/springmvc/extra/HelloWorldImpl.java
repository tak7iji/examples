package org.sample.springmvc.extra;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.sample.mybatis.TestTable;

@WebService
public class HelloWorldImpl {
    private ObjectBeanFactory factory = new ObjectBeanFactory();

    @WebMethod
    public List<TestTable> sayHi() throws Throwable {
        DBAccess dbAccess = factory.getBean();
        return dbAccess.dbAccess();
    }
    

}