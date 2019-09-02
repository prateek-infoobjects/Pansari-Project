package com.pansari.promoter.controller;

import com.pansari.promoter.exceptions.CustomException;
import com.pansari.promoter.entity.Item;
import com.pansari.promoter.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

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
}
