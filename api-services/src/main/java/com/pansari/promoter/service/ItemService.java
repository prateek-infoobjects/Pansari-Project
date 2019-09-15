package com.pansari.promoter.service;

import com.pansari.promoter.exceptions.CustomException;
import com.pansari.promoter.entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> listItems() throws CustomException;

    Item createItem(String itemName, String primaryCategory, String secondaryCategory);

    void deleteItem(int itemId) throws CustomException;
}
