package org.sample.springmvc.extra;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.FactoryBean;

public class MessageBeanFactory implements FactoryBean<MessageBean> {
    private static Logger log = Logger.getLogger(MessageBeanFactory.class);
    
    @Override
    public MessageBean getObject() throws Exception {
        log.info("Instantiate MessageBean");
        return new MessageBean();
    }
    
    @Override
    public Class<MessageBean> getObjectType() {
        // TODO Auto-generated method stub
        return MessageBean.class;
    }
    @Override
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return true;
    }
}
