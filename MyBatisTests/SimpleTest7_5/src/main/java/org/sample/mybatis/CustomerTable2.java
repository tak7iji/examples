package org.sample.mybatis;

public class CustomerTable2 extends CustomerTable {
    private int cId;
    private String cName;
    private String cAddress;
    public int getcId() {
        return cId;
    }
    public void setcId(int cId) {
        this.cId = cId;
    }
    public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    public String getcAddress() {
        return cAddress;
    }
    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }
}
