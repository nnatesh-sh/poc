package com.stubhub.gcp.csbff.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultObject {

    @JsonProperty("message")
    private String message;

    public ResultObject(String message) {
        super();
        this.message = message;
    }

    public ResultObject() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

