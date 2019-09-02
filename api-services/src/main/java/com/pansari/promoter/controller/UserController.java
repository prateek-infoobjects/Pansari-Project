package com.pansari.promoter.controller;

import com.pansari.promoter.exceptions.UserNotFoundException;
import com.pansari.promoter.model.LoginDto;
import com.pansari.promoter.entity.User;
import com.pansari.promoter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

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

}
