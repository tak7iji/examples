package org.sample.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.mybatis.TestTable;
import org.sample.springmvc.extra.DBAccess;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Configurable
@WebServlet(name="TestServlet", urlPatterns={"/list"})
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired DBAccess dba;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        System.out.println("Start Servlet: "+this);
        List<TestTable> data = dba.dbAccess();
        req.setAttribute("data", data);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( "/WEB-INF/views/list.jsp" );
        dispatcher.forward( req, res );
    }
}
