package com.pansari.promoter.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "saleid")
    private int saleId;

    @OneToOne()
    @JoinColumn(name = "userid")
    private User user;

    @Column(name = "selected_date")
    private String selectedDate;

    @Column(name = "other_sale")
    private String otherSale;

    @Column(name = "store_out_time")
    private String storeOutTime;

    @Column(name = "other_remarks")
    private String otherRemarks;

    @Column(name = "stock_not_available")
    private String stockNotAvailable;

    @Column(name = "stock_short")
    private String stockShort;

    @Column(name = "zone")
    private String zone;

    @OneToOne()
    @JoinColumn(name = "storeid")
    private Store store;

    @OneToMany(mappedBy="sale",cascade=CascadeType.ALL)
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private Set<ProductLine> productLines;

    private long created;

    public Set<ProductLine> getProductLines() {
        return productLines;
    }

    public void setProductLines(Set<ProductLine> productLines) {
        this.productLines = productLines;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public String getOtherSale() {
        return otherSale;
    }

    public void setOtherSale(String otherSale) {
        this.otherSale = otherSale;
    }

    public String getStoreOutTime() {
        return storeOutTime;
    }

    public void setStoreOutTime(String storeOutTime) {
        this.storeOutTime = storeOutTime;
    }

    public String getOtherRemarks() {
        return otherRemarks;
    }

    public void setOtherRemarks(String otherRemarks) {
        this.otherRemarks = otherRemarks;
    }

    public String getStockNotAvailable() {
        return stockNotAvailable;
    }

    public void setStockNotAvailable(String stockNotAvailable) {
        this.stockNotAvailable = stockNotAvailable;
    }

    public String getStockShort() {
        return stockShort;
    }

    public void setStockShort(String stockShort) {
        this.stockShort = stockShort;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
