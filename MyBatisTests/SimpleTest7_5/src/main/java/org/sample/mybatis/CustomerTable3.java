package org.sample.mybatis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_table")
public class CustomerTable3 extends CustomerTable {
    @Id
    @Column(name="c_id")
    private int cId;
    @Column(name="c_name")
    private String cName;
    @Column(name="c_address")
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
