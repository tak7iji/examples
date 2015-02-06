package org.sample.struts2.extra;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

public class ExtraTest4 extends ActionSupport implements StrutsStatics {
//public class ExtraTest4 extends ActionSupport implements StrutsStatics, CookiesAware {
//public class ExtraTest4 extends ActionSupport implements StrutsStatics, ServletRequestAware {
    private static final long serialVersionUID = 1L;
//    private HttpServletResponse response;
//    private Map<String, String> cookies;
//    private HttpServletRequest request;

    private String visited;
    private String JSESSIONID;
//    private Cookie[] cookies;
    
    
//    public void setServletResponse(HttpServletResponse response) {
//        this.response = response;
//    }
    
//    public void setCookiesMap(Map<String, String> cookies) {
//        this.cookies = cookies;
//    }
    
//    public Map<String, String> getCookies() {
//        return cookies;
//    }
    
    public String execute() {
//        ActionContext context = ActionContext.getContext();
//        HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
//        setCookies(request.getCookies());
//        if (cookies != null) System.out.println(cookies.get("visited"));
//        Cookie cookie = new Cookie("visited", "1");
//        response.addCookie(cookie);
//        ValueStack stack = ActionContext.getContext().getValueStack();
//        String value = stack.findString("visited");
//        System.out.println(stack);
//        System.out.println("Value: "+value);
        return SUCCESS;
    }


    public String getVisited() {
        return visited;
    }


    public void setVisited(String visited) {
        this.visited = visited;
    }


    public String getJSESSIONID() {
        return JSESSIONID;
    }


    public void setJSESSIONID(String jSESSIONID) {
        JSESSIONID = jSESSIONID;
    }


//    public Cookie[] getCookies() {
//        return cookies;
//    }


//    public void setCookies(Cookie[] cookies) {
//        this.cookies = cookies;
//    }

//    public HttpServletRequest getRequest() {
//        return request;
//    }

//    @Override
//    public void setServletRequest(HttpServletRequest request) {
//        this.request = request;
//    }
}
