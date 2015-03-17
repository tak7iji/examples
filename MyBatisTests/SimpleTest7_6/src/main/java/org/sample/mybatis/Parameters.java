package org.sample.mybatis;

public class Parameters {
    private int id;
    private String limitId;
    private String address;
    public Parameters(int id, String limitId, String address) {
        this.id = id;
        this.limitId = limitId;
        this.address = address;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLimitId() {
        return limitId;
    }
    public void setLimitId(String limitId) {
        this.limitId = limitId;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
