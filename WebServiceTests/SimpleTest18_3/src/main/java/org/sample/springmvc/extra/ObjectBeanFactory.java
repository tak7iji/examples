package org.sample.springmvc.extra;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class ObjectBeanFactory {
    public MessageBean getBean() {
        WebApplicationContext cc = ContextLoader.getCurrentWebApplicationContext();
        MessageBean mb = cc.getBean(MessageBean.class);
        return mb;
    }

}
