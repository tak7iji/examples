package org.sample.springmvc.exception;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

public class CustomMappingExceptionResolver extends
        AbstractHandlerExceptionResolver {
    @Resource
    private MessageSource messageSource;
    
    private Map<String, List<String>> exceptionMappings;

    public void setExceptionMappings(Map<String, List<String>> exceptionMappings) {
        this.exceptionMappings = exceptionMappings;
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
        MessageSourceAccessor messageAccessor = new MessageSourceAccessor(
                messageSource);
        List<String> list = exceptionMappings.get(ex.getClass().getName());
        if(list == null) {
            return null;
        }
        String view = list.get(0);
        String key = list.get(1);
        
        String message = messageAccessor.getMessage(key);
        
        ModelAndView mav = new ModelAndView(view);
        mav.addObject("message", message);
        
        return mav;
    }
}
