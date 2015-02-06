package org.sample.struts2.mapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.SessionAware;

public class MappingTest4 extends ActionSupport implements SessionAware {
    private Map<Locale, Map<String, String>> localeMap = new HashMap<Locale, Map<String, String>>();
    private Map<String, String> keyMethodMap = null;

    private TestFormBean message;
    private String execute;
    private Map<String, Object> sessionMap;

    public String getExecute() {
        return execute;
    }

    public void setExecute(String execute) {
        this.execute = execute;
    }

    public TestFormBean getMessage() {
        return message;
    }

    public void setMessage(TestFormBean message) {
        this.message = message;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Action(value = "/test4-dispatch")
    public String dispatch() {
        String res = "";
        Locale locale = (Locale) sessionMap.get("WW_TRANS_I18N_LOCALE");
        if (locale == null)
            locale = Locale.getDefault();
        System.out.println(locale.toString() + ":" + execute);

        String methodName = getMethodName(execute, locale);

        try {
            Method method = this.getClass().getMethod(methodName, null);
            res = (String) method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    public String dispatch1() {
        System.out.println(getTexts("test4")
                .getString("test4.submit.dispatch1"));
        return "dispatch1";
    }

    public String dispatch2() {
        System.out.println(getTexts("test4")
                .getString("test4.submit.dispatch2"));
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
        ResourceBundle bundle = getTexts("org.sample.struts2.mapping.MappingTest4");

        this.keyMethodMap = this.getKeyMethodMap();

        for (String key : this.keyMethodMap.keySet()) {
            String text = bundle.getString(key);

            if ((text != null) && !lookupMap.containsKey(text)) {
                lookupMap.put(text, key);
            }
        }

        return lookupMap;
    }

}
