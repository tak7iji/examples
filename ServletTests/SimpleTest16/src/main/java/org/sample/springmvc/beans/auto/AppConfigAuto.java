package org.sample.springmvc.beans.auto;

import org.sample.springmvc.auto.MessageBeanAuto2;
import org.sample.springmvc.beans.manual.MessageBean;
import org.sample.springmvc.beans.manual.MessageBean7;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages="org.sample.springmvc.auto")
@ImportResource("classpath:beans2.xml")
public class AppConfigAuto {
    
    // Bean定義ファイルに同名のBeanがあるので、これはスキップとなる
    @Bean
    public MessageBean messageBean() {
        MessageBean mb = new MessageBean();
        mb.setMessage("Hello Auto JavaConfig");
        return mb;
    }

    // AppConfigManualでも同名のBeanが定義されているが、こちらの方があとに定義されるので上書きされる
    @Bean
    public MessageBean7 messageBean7() {
        MessageBean7 mb7 = new MessageBean7();
        mb7.setMessage("Hello MB7 2");
        return mb7;
    }
    
    // ComponentScanによりMessageBeanAuto2が有効化されているため、これはスキップとなる
    @Bean
    public MessageBeanAuto2 messageBeanAuto2() {
        MessageBeanAuto2 mba2 = new MessageBeanAuto2();
        mba2.setMessage("Hello MBA2");
        return mba2;
    }
}
