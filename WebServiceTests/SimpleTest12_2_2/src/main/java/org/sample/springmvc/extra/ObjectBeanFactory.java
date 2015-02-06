package org.sample.springmvc.extra;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class ObjectBeanFactory {
    private static Logger log = Logger.getLogger(ObjectBeanFactory.class);

    public MessageBean getBean() {
        WebApplicationContext cc = ContextLoader.getCurrentWebApplicationContext();
        MessageBean mb = cc.getBean("mb", MessageBean.class);
        log.info("MessageBean: "+mb);
        return mb;
    }

}
