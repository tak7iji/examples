package org.sample.springmvc.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.sample.springmvc.extra.HelloWorldImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
@ComponentScan(basePackages={"org.sample.springmvc.extra"})
public class AppConfig {
    @Autowired
    Bus cxfBus;

    @Bean
    public Endpoint calculator() {
        EndpointImpl endpoint = new EndpointImpl(cxfBus, new HelloWorldImpl());
        endpoint.setAddress("/HelloWorld");
        endpoint.publish();
        return endpoint;
    }
}
