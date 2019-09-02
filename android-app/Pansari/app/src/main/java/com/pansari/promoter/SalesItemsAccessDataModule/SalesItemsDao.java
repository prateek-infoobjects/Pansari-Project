package com.pansari.promoter.SalesItemsAccessDataModule;

import com.pansari.promoter.salesmodule.SalesItems;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface SalesItemsDao {

    @Query("SELECT DISTINCT secondaryCategory FROM salesitems where primaryCategory IN  (:category)")
    String[] getSubCategories(String category);

    @Query("SELECT * FROM salesitems where primaryCategory IN  (:category) AND secondaryCategory  IN (:subCategory)")
    List<SalesItems> getItemNamesWithId(String category, String subCategory);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SalesItems> items);

    @Query("SELECT DISTINCT primaryCategory FROM salesitems")
    String[] getAllCategories();

    @Query("SELECT DISTINCT secondaryCategory FROM salesitems")
    String[] getAllSecondaryCategories();

    @Query("select distinct secondaryCategory from salesitems where itemName in (:item)")
    String getSecondaryCategory(String item);

    @Query("select distinct primaryCategory from salesitems where secondaryCategory in (:secCategory) and  itemName in (:item)")
    String getPrimaryCategory(String secCategory, String item);

}
