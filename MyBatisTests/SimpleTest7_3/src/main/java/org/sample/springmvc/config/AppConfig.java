package org.sample.springmvc.config;

import javax.sql.DataSource;
import javax.transaction.TransactionSynchronizationRegistry;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="org.sample.springmvc")
public class AppConfig extends WebMvcConfigurationSupport {
    @Bean
    public ViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver(); 
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
    
    @Bean
    public DataSource dataSource() {
        System.out.println("Set Datasource");
        DataSource ds = null;
        try {
            JndiTemplate jndi = new JndiTemplate();
            ds = jndi.lookup("java:comp/env/jdbc/tpcwDS", DataSource.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        // MyBatis-Springを利用する場合は、TransactionAwareDataSourceProxyでラップしなくてもよい
        return ds;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        System.out.println("Set TransactionManager");
        JtaTransactionManager txManager = new JtaTransactionManager();
        // Default: java:comp/UserTransaction
        txManager.setTransactionManagerName("java:comp/UserTransaction");
        // Default: false
        txManager.setAllowCustomIsolationLevels(true);
        // Default: java:comp/TransactionSynchronizationRegistry
        txManager.setTransactionSynchronizationRegistryName("java:comp/env/TransactionSynchronizationRegistry");

        return txManager;
    }
    
    @Bean(name="databaseIds")
    public PropertiesFactoryBean propertiesFactoryBean() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("databaseId.properties"));
        return propertiesFactoryBean;
    }
    
}
