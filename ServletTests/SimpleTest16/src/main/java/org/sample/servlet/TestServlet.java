package org.sample.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.springmvc.beans.auto.MessageBeanAuto;
import org.sample.springmvc.beans.manual.Card;
import org.sample.springmvc.beans.manual.MessageBean;
import org.sample.springmvc.beans.manual.MessageBean6;
import org.sample.springmvc.beans.manual.MessageBean8;
import org.sample.springmvc.beans.manual.MessageBean9;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

@WebServlet(name="TestServlet", urlPatterns={"/getbean"})
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        ApplicationContext appContext = ContextLoader.getCurrentWebApplicationContext();

        // @Componentと<bean>とで同じ名前で定義しているため、<bean>による定義が優先される
        MessageBean messageBean = appContext.getBean("messageBean", MessageBean.class);

        // @Component、<bean>それぞれで異なる名前のBeanインスタンスを定義しているので、一意に特定できないため以下のコードはエラーになる
        // "messageBean2"もしくは"mb2"を陽に指定する必要がある
        // MessageBean2 messageBean2 = appContext.getBean(MessageBean2.class);
        
        // "foo"という名前のBeanは定義されていないので取得することができない
        // MessageBeanAuto mBeanAuto = appContext.getBean("foo", MessageBeanAuto.class);

        // @Componentに属性を指定していないため、クラス名の先頭が小文字になったものがBean名となっている
        MessageBeanAuto mBeanAuto1 = appContext.getBean("messageBeanAuto", MessageBeanAuto.class);
        
        // @ComponentのみでBeanが定義されているので、Bean名を指定しなくても取得することができる
        MessageBeanAuto mBeanAuto2 = appContext.getBean(MessageBeanAuto.class);
        
        MessageBean6 mb6 = appContext.getBean("mb6", MessageBean6.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("message", messageBean.getMessage());

        // 実装クラスがVisaのみなので、下記のコードでVisaのインスタンスが取得できる
        Card card = appContext.getBean(Card.class);
        System.out.println(card);
        
        MessageBean8 mb8 = appContext.getBean("org.sample.springmvc.beans.manual.MessageBean8#0", MessageBean8.class);
        
        System.out.println("MessageBean9: " + appContext.getBean(MessageBean9.class));
        
        Map<String, MessageBean9> mb9Map = appContext.getBeansOfType(MessageBean9.class);
        for(String key : mb9Map.keySet()) {
            System.out.println(key + ": " + mb9Map.get(key));
        }
        
        req.setAttribute("data", map);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( "/WEB-INF/views/view.jsp" );
        dispatcher.forward( req, res );
    }
}
