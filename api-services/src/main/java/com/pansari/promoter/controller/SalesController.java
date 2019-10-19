package com.pansari.promoter.controller;

import com.pansari.promoter.entity.Sales;
import com.pansari.promoter.model.ItemDto;
import com.pansari.promoter.model.SalesDto;
import com.pansari.promoter.service.SalesService;
import com.pansari.promoter.service.SalesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/sale")
public class SalesController {

    private static final Logger logger = Logger.getLogger(SalesController.class.getName());

    @Autowired
    SalesService salesService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity createSale(@RequestBody SalesDto salesDto) {
        logger.info("Request received for user id - " + salesDto.getUserid() + " store - " + salesDto.getStoreid() +
                " for " + salesDto.getItems().size() + " items");
        try {
            salesService.createSale(salesDto);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
        }
        logger.info("Successfully created sale  for user id - " + salesDto.getUserid() + " store - " + salesDto.getStoreid() +
        " for " + salesDto.getItems().size() + " items");

        return new ResponseEntity<String>("{\"status\":\"success\",\"message\":\"SALE_RECORD_ADDED\"}", HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity getSales() {
        logger.info("fetch sales");
        try {
            List<Sales> sales = salesService.getSales();
            logger.info(String.valueOf(sales.size()));
            return new ResponseEntity<>(sales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
        }
    }


}
