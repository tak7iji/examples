package org.sample.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.mybatis.TestTable;
import org.sample.springmvc.extra.DBAccess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebServlet(name="TestServlet", urlPatterns={"/list"})
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        ApplicationContext appContext = 
                new ClassPathXmlApplicationContext("beans.xml");
        
        List<TestTable> data = appContext.getBean("dbAccess", DBAccess.class).dbAccess();
        req.setAttribute("data", data);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( "/WEB-INF/views/list.jsp" );
        dispatcher.forward( req, res );
    }
}
