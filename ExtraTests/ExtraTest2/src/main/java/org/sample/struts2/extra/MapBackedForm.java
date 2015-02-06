package org.sample.struts2.extra;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MapBackedForm implements Serializable {
    private Map<String, String> value;
    
    public void setValue(Map<String, String> value) {
        this.value = value;
    }
    
    public Map<String, String> getValue() {
        return this.value;
    }

}
