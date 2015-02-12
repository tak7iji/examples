package org.sample.springmvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="testtable")
public class TestTable implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    
    @Column(name="address")
    private String address;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
