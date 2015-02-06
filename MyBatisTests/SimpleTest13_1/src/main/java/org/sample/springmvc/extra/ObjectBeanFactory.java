package org.sample.springmvc.extra;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class ObjectBeanFactory {
    private static Logger log = Logger.getLogger(ObjectBeanFactory.class);

    public DBAccess getBean() {
        WebApplicationContext cc = ContextLoader.getCurrentWebApplicationContext();
        DBAccess dbAccess = cc.getBean("dbAccess", DBAccess.class);
        log.info("DBAccess: "+dbAccess);
        return dbAccess;
    }

}
