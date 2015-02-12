package org.sample.springmvc.extra;

import org.apache.log4j.Logger;

public class ObjectBeanFactory {
    private static Logger log = Logger.getLogger(ObjectBeanFactory.class);

    public DBAccess getBean() {
        DBAccess dbAccess = new DBAccess();
        log.info("DBAccess: "+dbAccess);
        return dbAccess;
    }

}
