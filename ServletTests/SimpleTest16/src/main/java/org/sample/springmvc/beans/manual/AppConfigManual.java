package org.sample.springmvc.beans.manual;

import org.sample.springmvc.beans.manual.MessageBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

// このクラス内でbeans.xmlを読み込む。beans.xmlではcomponent-scanによりApｐConfigAutoが読み込まれる
@Configuration
//@PropertySourceと<context:property-placeholder>では前者が優先されている
@PropertySource(value = {"classpath:message-annotation.properties"})
@ComponentScan(basePackages="org.sample.springmvc.auto2")
@ImportResource("classpath:beans.xml")
public class AppConfigManual {
    
    @Bean
    public MessageBean messageBean() {
        MessageBean mb = new MessageBean();
        mb.setMessage("Hello Manual JavaConfig");
        return mb;
    }

    @Bean
    public MessageBean3 messageBean3() {
        MessageBean3 mb = new MessageBean3();
        return mb;
    }
    
    @Bean
    public MessageBean6 mb6() {
        return new MessageBean6();
    }
    
    @Bean
    public MessageBean7 messageBean7() {
        MessageBean7 mb7 = new MessageBean7();
        mb7.setMessage("Hello MB7");
        return mb7;
    }
}
