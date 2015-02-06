package org.sample.springmvc.mapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MappingTest4 {
    @Resource
    private MessageSource messageSource;

    private Map<Locale, Map<String, String>> localeMap = new HashMap<Locale, Map<String, String>>();
    private Map<String, String> keyMethodMap = null;

    @RequestMapping(value = "/test4", method = RequestMethod.GET)
    public String execute(Model model) {
        model.addAttribute("message", new TestFormBean());

        return "lookupdispatchaction";
    }

    @RequestMapping(value = "/test4-dispatch", method = RequestMethod.POST)
    public String dispatch(@RequestParam String execute,
            @ModelAttribute("message") TestFormBean message, Locale locale) {

        String methodName = getMethodName(execute, locale);
        String result = "";
        try {
            Method method = this.getClass().getMethod(methodName,
                    TestFormBean.class);
            result = (String) method.invoke(this, message);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public String dispatch1(TestFormBean message) {
        System.out.println(message.getMessage());
        return "dispatch1";
    }

    public String dispatch2(TestFormBean message) {
        System.out.println(message.getMessage());
        return "dispatch2";
    }

    private Map<String, String> getKeyMethodMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("submit.dispatch1", "dispatch1");
        map.put("submit.dispatch2", "dispatch2");
        return map;
    }

    private String getMethodName(String execute, Locale locale) {
        Map<String, String> lookupMap;
        synchronized (localeMap) {
            lookupMap = this.localeMap.get(locale);

            if (lookupMap == null) {
                lookupMap = this.initLookupMap(locale);
                this.localeMap.put(locale, lookupMap);
            }

        }
        String key = (String) lookupMap.get(execute);

        String methodName = (String) keyMethodMap.get(key);

        return methodName;
    }

    private Map<String, String> initLookupMap(Locale locale) {
        Map<String, String> lookupMap = new HashMap<String, String>();
        MessageSourceAccessor messageAccessor = new MessageSourceAccessor(
                messageSource);

        this.keyMethodMap = this.getKeyMethodMap();

        for (String key : this.keyMethodMap.keySet()) {
            String text = messageAccessor.getMessage(key);

            if ((text != null) && !lookupMap.containsKey(text)) {
                lookupMap.put(text, key);
            }
        }

        return lookupMap;
    }

}
