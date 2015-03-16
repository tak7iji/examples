package org.sample.springmvc.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.apache.log4j.Logger;
import org.sample.springmvc.extra.MultiRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
@ComponentScan(basePackages="org.sample.springmvc")
public class AppConfig {
    private Logger logger = Logger.getLogger(AppConfig.class);
    
    @Autowired
    Bus cxfBus;

    @Bean
    public MultiRecord multiRecord() {
        return new MultiRecord();
    }
    
    @Bean
    public Endpoint jaxwsEndpoint() {
        logger.info(cxfBus.toString());
        
        EndpointImpl endpoint = new EndpointImpl(cxfBus, multiRecord());
        endpoint.setAddress("/MultiRecord");
        endpoint.publish();
        return endpoint;
    }
    
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
      CXFServlet cxfServlet = new CXFServlet();

      ServletRegistrationBean servletRegistrationBean =
          new ServletRegistrationBean(cxfServlet, "/services/*");
      servletRegistrationBean.setLoadOnStartup(1);
      return servletRegistrationBean;
    }
    
    @Bean(name="databaseIds")
    public PropertiesFactoryBean propertiesFactoryBean() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("databaseId.properties"));
        return propertiesFactoryBean;
    }
    
}
