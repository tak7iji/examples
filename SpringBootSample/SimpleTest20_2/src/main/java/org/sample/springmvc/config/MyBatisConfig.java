package org.sample.springmvc.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.sample.mybatis")
public class MyBatisConfig {
    private Logger logger = Logger.getLogger(MyBatisConfig.class);
    
    @Autowired
    DataSource dataSource;
    
    @Resource
    Properties databaseIds;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        logger.info(dataSource.toString());
        
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTransactionFactory(new ManagedTransactionFactory());
        sqlSessionFactoryBean.setDataSource(dataSource);

        // set database provider
        VendorDatabaseIdProvider provider = new VendorDatabaseIdProvider();
        provider.setProperties(databaseIds);
        sqlSessionFactoryBean.setDatabaseIdProvider(provider);
        
        // create SqlSesionFactory
        SqlSessionFactory sessionFactory = sqlSessionFactoryBean.getObject();
        logger.info(sessionFactory.getConfiguration().getDatabaseId());
        
        return sessionFactory;
    }
}
