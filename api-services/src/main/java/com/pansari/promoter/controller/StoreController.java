package com.pansari.promoter.controller;

import com.pansari.promoter.exceptions.CustomException;
import com.pansari.promoter.entity.Store;
import com.pansari.promoter.model.StoreDto;
import com.pansari.promoter.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/stores")
public class StoreController {

    private static final Logger logger = Logger.getLogger(StoreController.class.getName());

    @Autowired
    StoreService storeService;

    @RequestMapping(value = "/listbyzone", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity listStoresByZone(@RequestParam String zone) throws CustomException {
        zone = zone.replaceAll("^\"|\"$", "").toUpperCase();
        List<Store> stores = null;
        try {
            stores = storeService.listStoresByZone(zone);
        } catch (CustomException e) {
            return new ResponseEntity<CustomException>(e, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<CustomException>(new CustomException(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
    }

    @RequestMapping(value = "/getzones", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity getZones() throws CustomException {

        List<String> zones = null;
        try {
            zones = storeService.getZones();
        } catch (CustomException e) {
            e.printStackTrace();
            return new ResponseEntity<CustomException>(e, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<CustomException>(new CustomException(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<String>>(zones, HttpStatus.OK);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity createStore(@RequestBody StoreDto storeDto) throws CustomException {
        if (storeDto.getStoreName().isEmpty()) {
            logger.severe("Store name is invalid");
            return new ResponseEntity<CustomException>(new CustomException("Store name is invalid"), HttpStatus.BAD_REQUEST);
        }
        Store store = null;
        try {
            store = storeService.createStore(storeDto.getStoreName(), storeDto.getZone());
            logger.info("Store with name - " +storeDto.getStoreName() + " created with id - "+ store.getStoreId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<CustomException>(new CustomException(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Store>(store, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity deleteStore(@RequestParam int storeId) throws CustomException {
        try {
            storeService.deleteStore(storeId);
            logger.info("Store with id - " +storeId+ " deleted successfully");
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

    @RequestMapping(value = "/listall", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity getStores() throws CustomException {
        List<Store> stores=null;
        try {
            stores=storeService.getStores();
        }
        catch (CustomException e) {
            e.printStackTrace();
            return new ResponseEntity<CustomException>(e, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<CustomException>(new CustomException(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Store>>( stores, HttpStatus.OK);
    }


}
