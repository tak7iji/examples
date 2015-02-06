package org.sample.struts1.extra;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts.action.ActionForm;

public class MapBackedForm extends ActionForm implements Serializable {
    private Map<String, Object> values = new HashMap<String, Object>();

    public Map<String, Object> getValues() {
        return this.values;
    }

    public void setValue(String key, Object value) {
        this.values.put(key, value);
    }
    
    public Object getValue(String key) {
        return this.values.get(key);
    }
}
