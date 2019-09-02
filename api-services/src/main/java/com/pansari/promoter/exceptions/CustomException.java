package com.pansari.promoter.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomException extends Exception {
    private int code;

    public CustomException() {
        this(500);
    }

    public CustomException(int code) {
        this(code, "Error while processing the request", null);
    }

    public CustomException(String message) {
        this(500, message, null);
    }

    public CustomException(int code, String message) {
        this(code, message, null);
    }

    public CustomException(int code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
