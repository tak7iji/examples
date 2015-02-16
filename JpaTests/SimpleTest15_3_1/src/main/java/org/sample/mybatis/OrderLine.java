package org.sample.mybatis;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_line")
public class OrderLine {
    @Id
    @Column(name="id")
    private long id;
    @OneToMany(mappedBy="o", fetch=FetchType.EAGER)
    private Set<Items> items;
    @Column(name="qty")
    private long qty;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getQty() {
        return qty;
    }
    public void setQty(long qty) {
        this.qty = qty;
    }
    public Set<Items> getItems() {
        return items;
    }
    public void setItems(Set<Items> items) {
        this.items = items;
    }
}
