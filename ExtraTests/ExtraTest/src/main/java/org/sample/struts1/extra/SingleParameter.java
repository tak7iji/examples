package org.sample.struts1.extra;

public class SingleParameter {

    private String singleParameter;

    public SingleParameter(String string) {
        this.setSingleParameter(string);
    }

    public String getSingleParameter() {
        return singleParameter;
    }

    public void setSingleParameter(String singleParameter) {
        this.singleParameter = singleParameter;
    }

}
