package org.sample.springmvc.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={"org.sample.springmvc.extra", "org.sample.springmvc.config"})
public class AppConfig {
    @Bean
    public JndiTemplate jndiTemplate() {
        return new JndiTemplate();
    }
    
    @Bean
    public DataSource dataSource() {
        DataSource ds = null;
        try {
            ds = jndiTemplate().lookup("java:jboss/datasources/jdbc/tpcwDS", DataSource.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return ds;
    }
    
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        EntityManagerFactory factory = null;
        try {
            factory = jndiTemplate().lookup("java:/persistence/emf", EntityManagerFactory.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return factory;
    }
    
    @Bean
    public PlatformTransactionManager transctionManager() {
        return new JtaTransactionManager();
    }
}
