package org.sample.springmvc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="org.sample.springmvc")
public class AppConfig {
    @Bean
    public DataSource dataSource() {
        System.out.println("Set Datasource");
        DataSource ds = null;
        try {
            JndiTemplate jndi = new JndiTemplate();
            ds = jndi.lookup("java:jboss/datasources/jdbc/tpcwDS", DataSource.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return ds;
    }
    
    @Bean(name="databaseIds")
    public PropertiesFactoryBean propertiesFactoryBean() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("databaseId.properties"));
        return propertiesFactoryBean;
    }
    
}
