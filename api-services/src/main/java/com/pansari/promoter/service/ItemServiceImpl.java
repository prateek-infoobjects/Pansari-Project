package com.pansari.promoter.service;

import com.pansari.promoter.dao.ItemDao;
import com.pansari.promoter.exceptions.CustomException;
import com.pansari.promoter.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Override
    @Transactional
    public List<Item> listItems() throws CustomException {

        return itemDao.listItems();
    }
}
