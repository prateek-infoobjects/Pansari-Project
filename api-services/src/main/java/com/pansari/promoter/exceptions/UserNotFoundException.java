package com.pansari.promoter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends CustomException {
    public UserNotFoundException()
    {
        super(401,"Incorrect username or password");
    }
}
