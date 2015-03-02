package org.sample.springmvc.extra;

import org.sample.springmvc.api.DBAccess;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class ObjectBeanFactory {
    public DBAccess getBean() {
        System.out.println("ClassLoader: "+ContextLoader.class.getClassLoader());
        WebApplicationContext cc = ContextLoader.getCurrentWebApplicationContext();
        DBAccess dbAccess = cc.getBean("dbAccess", DBAccess.class);
        return dbAccess;
    }
}
