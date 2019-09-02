package com.pansari.promoter.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessage {

    @JsonProperty
    private String error_code;
    @JsonProperty
    private String error_message;

    public ErrorMessage(String error_code, String error_message) {
        this.error_code = error_code;
        this.error_message = error_message;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }


}
