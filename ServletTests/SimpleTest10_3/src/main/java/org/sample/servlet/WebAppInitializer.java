package org.sample.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        final XmlWebApplicationContext ctx = new XmlWebApplicationContext();
        ctx.setConfigLocation("WEB-INF/beans.xml");
         
        servletContext.addListener(new ContextLoaderListener(ctx));
        ctx.setServletContext(servletContext);
        ctx.refresh();

        TestServlet servlet = new TestServlet();
        Dynamic dynamic = servletContext.addServlet("TestServlet", servlet);
        dynamic.addMapping("/list");
        dynamic.setLoadOnStartup(1);
        System.out.println("Register Servlet: "+servlet);
        
        AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
        bpp.setBeanFactory(ctx.getAutowireCapableBeanFactory());
        bpp.processInjection(servlet);
    }
}
