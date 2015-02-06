package org.sample.springmvc.exception;

import java.net.MalformedURLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebAppInitializerImpl implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        try {
            String appName = getAppName(servletContext);
            servletContext.log("appName: " + appName);
            servletContext.setAttribute("appName", appName);
            servletContext.setAttribute("appUrl", "/" + appName);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    private String getAppName(ServletContext servletContext)
            throws MalformedURLException {

        String path = servletContext.getResource("/").getPath();
        String[] split = path.split("/");

        return split[split.length - 1];
    }
}
