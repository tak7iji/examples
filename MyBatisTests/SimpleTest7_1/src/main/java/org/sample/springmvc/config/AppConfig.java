package org.sample.springmvc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.sample.mybatis.SqlMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="org.sample")
public class AppConfig {
    @Bean
    public ViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver(); 
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        System.out.println("Set SqlSessionFactory");
        
        try {
            DataSource dataSource = dataSource();
            // 設定ファイルを使わずにSqlSessionFactoryを作成

            TransactionFactory transactionFactory = new ManagedTransactionFactory();
            Environment environment = new Environment("development", transactionFactory, dataSource);
            org.apache.ibatis.session.Configuration conf = new org.apache.ibatis.session.Configuration(environment);

            // DatabaseMetaData#getDatabaseProductName()から返された文字列が下記プロパティキーの文字列を含む場合に、
            // プロパティ値をDatabaseIdとして設定する
            Properties props = new Properties();
            props.setProperty("Oracle", "oracle");
            props.setProperty("PostgreSQL", "postgresql");
            props.setProperty("MySQL", "mysql");
            VendorDatabaseIdProvider provider = new VendorDatabaseIdProvider();
            provider.setProperties(props);
            conf.setDatabaseId(provider.getDatabaseId(dataSource));
            
            // SqlMapperのpackageからSqlMapper.xmlを検索して読み込み
            // addMapperにより追加されたClassはMapperRegistryに登録され、SqlSession#getMapperで取得できるようになる
            conf.addMapper(SqlMapper.class);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(conf);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(sqlSessionFactory);

        return sqlSessionFactory;
    }
    
    @Bean
    public DataSource dataSource() {
        System.out.println("Set Datasource");
        DataSource ds = null;
        try {
            // InitialContextを使っても大して変わらない？キャストが不要なのは良いかも
            JndiTemplate jndi = new JndiTemplate();
            ds = jndi.lookup("java:comp/env/jdbc/tpcwDS", DataSource.class);
        } catch (Exception ex) {}
        
        // SqlSessionFactoryに渡されたDataSourceからコネクションを取得する際に、直接DataSource#getConnection()を
        // 呼ばないようにするためにDataSourceをTransactionAwareDataSourceProxyでラップして返却
        // ここでラップしないで、Environment構築時にラップしてもよいと思われる
        return new TransactionAwareDataSourceProxy(ds);
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        System.out.println("Set TransactionManager");
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        
        // DataSourceTransactionManager#setDataSource()では渡されたDataSourceがTransactionAwareDataSourceProxyの
        // インスタンスであった場合、元のDataSourceを保持している
        dataSourceTransactionManager.setDataSource(dataSource());
 
        return dataSourceTransactionManager;
    }
}
