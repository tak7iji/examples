package org.sample.struts1.extra;

import java.util.Map;

public class MappedParameter {

    private Map<String, String> mappedValue;

    public MappedParameter(Map<String, String> map) {
        this.setMappedValue(map);
    }

    public Map<String, String> getMappedValue() {
        return mappedValue;
    }

    public void setMappedValue(Map<String, String> mappedValue) {
        this.mappedValue = mappedValue;
    }

}
