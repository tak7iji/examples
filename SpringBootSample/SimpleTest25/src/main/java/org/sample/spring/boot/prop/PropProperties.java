package org.sample.spring.boot.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "prop", ignoreUnknownFields = false)
public class PropProperties {
    private String test1;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

}
