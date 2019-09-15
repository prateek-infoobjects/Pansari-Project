package com.pansari.promoter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="itemid")
    private int itemId;

    @Column(name="itemname")
    private String itemName;

    @Column(name="primarycategory", nullable = false)
    private String primaryCategory;

    @Column(name="secondarycategory", nullable = false)
    private String secondaryCategory;

    @Column(name = "active", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean active;

    @JsonIgnore
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public Item(){}
    public Item(int itemId)
    {
        this.itemId=itemId;
    }

    public Item(int itemId, String itemName)
    {
        this.itemId=itemId;
        this.itemName=itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrimaryCategory() {
        return primaryCategory;
    }

    public void setPrimaryCategory(String primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    public String getSecondaryCategory() {
        return secondaryCategory;
    }

    public void setSecondaryCategory(String secondaryCategory) {
        this.secondaryCategory = secondaryCategory;
    }


}
