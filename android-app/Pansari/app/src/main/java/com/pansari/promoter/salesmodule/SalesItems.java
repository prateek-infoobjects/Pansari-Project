package com.pansari.promoter.salesmodule;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "SalesItems")
public class SalesItems {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "itemId")
    private int itemId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @ColumnInfo(name = "primaryCategory")
    private String primaryCategory;

    @ColumnInfo(name = "secondaryCategory")
    private String secondaryCategory;

    @ColumnInfo(name = "itemName")
    private String itemName;

    private String quantityValue;


    public String getQuantityValue() {
        return quantityValue;
    }

    public void setQuantityValue(String quantityValue) {
        this.quantityValue = quantityValue;
    }
}
