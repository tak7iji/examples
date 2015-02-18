package org.sample.springmvc.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.sample.mybatis")
public class MyBatisConfig {
    @Autowired
    DataSource dataSource;
    
    @Resource
    Properties databaseIds;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTransactionFactory(new ManagedTransactionFactory());
        sqlSessionFactoryBean.setDataSource(dataSource);

        // set database provider
        VendorDatabaseIdProvider provider = new VendorDatabaseIdProvider();
        provider.setProperties(databaseIds);
        sqlSessionFactoryBean.setDatabaseIdProvider(provider);
        
        // create SqlSesionFactory
        SqlSessionFactory sessionFactory = sqlSessionFactoryBean.getObject();
        System.out.println(sessionFactory.getConfiguration().getDatabaseId());
        
        return sessionFactory;
    }
}
