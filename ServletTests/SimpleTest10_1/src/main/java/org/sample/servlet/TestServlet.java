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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebServlet(name="TestServlet", urlPatterns={"/list"})
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired DBAccess dbAccess;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
          config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        List<TestTable> data = dbAccess.dbAccess();
        req.setAttribute("data", data);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( "/WEB-INF/views/list.jsp" );
        dispatcher.forward( req, res );
    }
}
