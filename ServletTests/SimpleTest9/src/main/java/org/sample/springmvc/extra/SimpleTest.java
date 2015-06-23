package org.sample.springmvc.extra;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@Scope("prototype")
public class SimpleTest {
    /**
     * 実際に利用する場所でのみ@Autowiredによるインスタンス化をするために、View表示用クラスとログイン処理用クラスを分けている
     * 仮に同じクラスにlogin()とexecute()を含めた場合、execute()ではMessageBeanをインスタンス化する必要は無い（引数として受け取るため）にもかかわらず、インスタンス化されてしまう
     * ただし、@Autowiredを利用せずlogin()内でのみインスタンス化を行い、Modelに格納するのであればクラスを分ける必要は無い
     */
//    @Autowired MessageBean mb;

    @RequestMapping("/logon")
    public String login(HttpServletRequest request, Model model) {
        ApplicationContext context = 
                RequestContextUtils.getWebApplicationContext(request);
        MessageBean mb = context.getBean("mb2", MessageBean.class);
        model.addAttribute("mb", mb);
        return "login";
    }
    
}