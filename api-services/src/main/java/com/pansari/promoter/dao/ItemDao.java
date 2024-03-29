package com.pansari.promoter.dao;

import com.pansari.promoter.entity.Item;

import java.util.List;

public interface ItemDao {

    List<Item> listItems();

    Item findById(int itemId);

    Item createItem(String itemName, String primaryCategory, String secondaryCategory);

    void deleteItem(Item item);
}
