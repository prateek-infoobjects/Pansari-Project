package com.pansari.promoter.service;

import com.pansari.promoter.exceptions.CustomException;
import com.pansari.promoter.entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> listItems() throws CustomException;
}
