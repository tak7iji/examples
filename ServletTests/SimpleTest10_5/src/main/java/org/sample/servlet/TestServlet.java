package org.sample.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
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

// Servletクラスに対して@Configurableを付加しても、ContextLoaderListenerの実行前にクラスがロードされているので、Load-Time Weavingの対象になっていない
//@Configurable
@WebServlet(name="TestServlet", urlPatterns={"/list"})
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 下記コードを有効にすると、TestServletクラスのロード時にあわせてDBAccessクラスもロードされる。
    // このタイミングでは、ContextLoaderListenerはロードされていないため、TestServlet/DBAccessともにWeaving対象にならない。
    // したがって、dbGet()内でnew DBAccess()としても単にDBAccessがインスタンス化されるだけでLoad-Time Weavingが働かない。
//    @Autowired DBAccess dbAccess;
//    private DBAccess dba;
    
    public TestServlet() {
        System.out.println("Startup TestServlet: "+this+"("+this.getClass().getClassLoader()+")");
    }
  
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        System.out.println("Start Servlet: "+this+"("+this.getClass().getClassLoader()+")");
//        List<TestTable> data = dbAccess.dbAccess();
        List<TestTable> data = new DBAccess().dbAccess();
        req.setAttribute("data", data);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( "/WEB-INF/views/list.jsp" );
        dispatcher.forward( req, res );
    }
}
