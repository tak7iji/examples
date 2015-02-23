package org.sample.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.springmvc.auto.MessageBeanAuto2;
import org.sample.springmvc.auto2.MessageBeanAuto3;
import org.sample.springmvc.beans.auto.MessageBeanAuto;
import org.sample.springmvc.beans.manual.MessageBean;
import org.sample.springmvc.beans.manual.MessageBean2;
import org.sample.springmvc.beans.manual.MessageBean3;
import org.sample.springmvc.beans.manual.MessageBean4;
import org.sample.springmvc.beans.manual.MessageBean5;
import org.sample.springmvc.beans.manual.MessageBean6;
import org.sample.springmvc.beans.manual.MessageBean7;
import org.sample.springmvc.beans.manual.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebServlet(name="TestServlet2", urlPatterns={"/autowired"})
public class TestServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired MessageBean messageBean;
    @Autowired MessageBean2 mb2;
    @Autowired MessageBean2 messageBean2;
    // "_mb2"という名前のBeanは無いためエラーとなる
    // @Autowired MessageBean2 _mb2;
    
    // "mba"という名前でBeanは定義されていないが、MessageBeanAutoのインスタンスが特定できるので取得可能
    @Autowired MessageBeanAuto mba;
    @Autowired MessageBean3 messageBean3;
    @Autowired MessageBean4 messageBean4;
    
    @Autowired MessageBean5 messageBean5;
    
    // JavaConfigのメソッド名と異なっても、インスタンスが特定できるため取得可能
    @Autowired MessageBean6 mBean6;
    
    @Autowired MessageBean7 messageBean7;
    
    // UserBeanインタフェースに対して二つの実装がBeanとして公開されているため、そのままでは一意に特定できない
    // 一つの実装しかBeanとして定義されていないか、@Primaryがついた実装があればければ、以下のコードでもInjectされる
    // @Primaryがついた実装が無くても、@QualifierでInjectするBean名を指定することも可能
    @Autowired @Qualifier("englishUserBean") UserBean userBean;
    // 実際に有効なのは、Bean名を特定している以下のコード
//    @Autowired UserBean japaneseUserBean;
    
    @Autowired MessageBeanAuto2 messageBeanAuto2;
    
    @Autowired MessageBeanAuto3 messageBeanAuto3;
    
    @Override
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("message", messageBean.getMessage());
        
        System.out.println(mb2.getMessage());
        System.out.println(messageBean2.getMessage());
        System.out.println(mba);
        System.out.println(messageBean3.getMessage());
        System.out.println(messageBean4.getMessage());
        System.out.println(messageBean5.getMessage());
        System.out.println(mBean6);
//        System.out.println(japaneseUserBean);
        System.out.println(userBean);
        System.out.println(messageBean7.getMessage());
        System.out.println(messageBeanAuto2.getMessage());
        System.out.println(messageBeanAuto3.sayHelo());
        System.out.println(messageBeanAuto3.sayHelo2());
        System.out.println(messageBeanAuto3.sayHelo3());
        System.out.println(messageBeanAuto3.sayHelo4());
        System.out.println(messageBeanAuto3.sayHelo5());
        System.out.println(messageBeanAuto3.sayHelo6());
        System.out.println(messageBeanAuto3.sayHelo7());
        System.out.println(messageBeanAuto3.sayHelo8());

        req.setAttribute("data", map);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( "/WEB-INF/views/view.jsp" );
        dispatcher.forward( req, res );
    }
}
