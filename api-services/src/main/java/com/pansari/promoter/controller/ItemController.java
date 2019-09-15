package com.pansari.promoter.controller;

import com.pansari.promoter.entity.Store;
import com.pansari.promoter.exceptions.CustomException;
import com.pansari.promoter.entity.Item;
import com.pansari.promoter.model.ItemCreateDto;
import com.pansari.promoter.model.ItemDto;
import com.pansari.promoter.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/items")
public class ItemController {

    private static final Logger logger = Logger.getLogger(ItemController.class.getName());


    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/list",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity list() throws CustomException {
        List<Item> items=null;
        try {
            items = itemService.listItems();
        }
        catch(CustomException e)
        {
            e.printStackTrace();
            return new ResponseEntity<CustomException>(e, HttpStatus.BAD_REQUEST);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<CustomException>(new CustomException(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity createItems(@RequestBody ItemCreateDto itemDto) throws CustomException {
        System.out.println(itemDto.getItemname() +","+ itemDto.getPrimaryCategory() +","+itemDto.getSecondaryCategory());
        if (itemDto.getItemname().isEmpty() || itemDto.getPrimaryCategory().isEmpty() || itemDto.getSecondaryCategory().isEmpty()) {
            logger.severe("Item parameters are invalid");
            return new ResponseEntity<CustomException>(new CustomException("Item parameters are invalid"), HttpStatus.BAD_REQUEST);
        }
        Item item = null;
        try {
            item = itemService.createItem(itemDto.getItemname(),itemDto.getPrimaryCategory(), itemDto.getSecondaryCategory());
            logger.info("Item with name - " +item.getItemName() + " created with id - "+ item.getItemId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<CustomException>(new CustomException(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE
    )
    public @ResponseBody
    ResponseEntity deleteItems(@RequestParam int itemId) throws CustomException {
        try {
            itemService.deleteItem(itemId);
            logger.info("Item with id - " +itemId+ " deleted successfully");
        }
        catch (CustomException e) {
            e.printStackTrace();
            return new ResponseEntity<CustomException>(e, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<CustomException>(new CustomException(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("", HttpStatus.OK);
    }
}
