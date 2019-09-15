package com.pansari.promoter.controller;

import com.pansari.promoter.entity.Store;
import com.pansari.promoter.exceptions.CustomException;
import com.pansari.promoter.exceptions.UserNotFoundException;
import com.pansari.promoter.model.LoginDto;
import com.pansari.promoter.entity.User;
import com.pansari.promoter.model.StoreDto;
import com.pansari.promoter.model.UserDto;
import com.pansari.promoter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


@Controller
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity authenticateUser(@RequestBody LoginDto loginDto) {
        User user = userService.authenticateUser(loginDto.getUsername(), loginDto.getPassword());
        if (user == null)
        {
            return new ResponseEntity<UserNotFoundException>(new UserNotFoundException(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/users",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users == null)
        {
            return new ResponseEntity<UserNotFoundException>(new UserNotFoundException(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity createUser(@RequestBody UserDto userDto) throws CustomException {
        if (userDto.getUsername().isEmpty() || userDto.getName().isEmpty() || userDto.getPassword().isEmpty()) {
            logger.severe("Name/username/password is invalid");
            return new ResponseEntity<CustomException>(new CustomException("Name/username/password is invalid"), HttpStatus.BAD_REQUEST);
        }
        int userId;
        try {
            userId = userService.createUser(userDto.getName().trim(), userDto.getUsername().trim(), userDto.getPassword().trim());
            logger.info("User with name - " +userDto.getName().trim() + " created with id - "+ userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<CustomException>(new CustomException(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Integer>(userId, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity deleteStore(@RequestParam int userId) throws CustomException {
        try {
            userService.deleteUserById(userId);
            logger.info("User with id - " +userId+ " deleted successfully");
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
