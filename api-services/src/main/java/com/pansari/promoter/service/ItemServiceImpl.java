package com.pansari.promoter.service;

import com.pansari.promoter.dao.ItemDao;
import com.pansari.promoter.exceptions.CustomException;
import com.pansari.promoter.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = Logger.getLogger(ItemServiceImpl.class.getName());

    @Autowired
    ItemDao itemDao;

    @Override
    @Transactional
    public List<Item> listItems() throws CustomException {

        return itemDao.listItems();
    }

    @Override
    @Transactional
    public Item createItem(String itemName, String primaryCategory, String secondaryCategory) {
        return itemDao.createItem(itemName, primaryCategory, secondaryCategory);
    }

    @Override
    @Transactional
    public void deleteItem(int itemId) throws CustomException {
        Item item = itemDao.findById(itemId);
        if(item==null)
        {
            logger.warning("Item doesn't exists");
            throw new CustomException(400, "Wrong item id received");
        }
        item.setActive(false);
        itemDao.deleteItem(item);
    }
}
