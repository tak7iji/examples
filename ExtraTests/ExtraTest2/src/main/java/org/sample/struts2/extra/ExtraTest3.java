package org.sample.struts2.extra;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class ExtraTest3 extends ActionSupport {
    private MapBackedForm value;
    private Map<String, String> result;
    
    public String execute() {
        setResult(getValue().getValue());
        return SUCCESS;
    }

    public Map<String, String> getResult() {
        return result;
    }

    public void setResult(Map<String, String> result) {
        this.result = result;
    }

    public MapBackedForm getValue() {
        return value;
    }

    public void setValue(MapBackedForm value) {
        this.value = value;
    }

}
