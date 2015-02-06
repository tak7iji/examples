package org.sample.springmvc.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.sample.mybatis.Mapper;
import org.sample.mybatis.TableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@MapperScan(basePackages="org.sample.mybatis", annotationClass=Mapper.class) // SqlSessionTemplate版でMapper Classを登録するために指定
public class MyBatisConfig {
    @Autowired
    DataSource dataSource;
    
    @Resource
    Properties databaseIds;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
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
    
    @Bean
    public TableMapper sqlMapper() throws Exception {
        // SqlSessionTemplate版
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sessionTemplate.getMapper(TableMapper.class);
        
        // MapperFactoryBean版
//        MapperFactoryBean<TableMapper> mfb = new MapperFactoryBean<TableMapper>();
//        mfb.setMapperInterface(TableMapper.class);
//        mfb.setSqlSessionFactory(sqlSessionFactory());
        // afterPropertiesSet()を実行しないとTableMapper.classがMapperRegistryに登録されない
//        mfb.afterPropertiesSet();
//        return mfb.getObject();
    }
}
