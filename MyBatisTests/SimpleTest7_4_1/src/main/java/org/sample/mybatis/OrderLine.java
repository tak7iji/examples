package org.sample.mybatis;

import java.util.Set;

public class OrderLine {
    private long id;
    private Set<Items> items;
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
