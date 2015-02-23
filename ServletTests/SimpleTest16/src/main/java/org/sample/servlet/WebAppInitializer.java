package org.sample.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.sample.springmvc.beans.manual.AppConfigManual;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
//        final XmlWebApplicationContext ctx = new XmlWebApplicationContext();
//        ctx.setConfigLocation("classpath:beans.xml");

        // 最初に読み込まれるのはAppConfigManual
        final AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfigManual.class);
        
        servletContext.addListener(new ContextLoaderListener(ctx));
        ctx.setServletContext(servletContext);
        ctx.refresh();

    }

}
