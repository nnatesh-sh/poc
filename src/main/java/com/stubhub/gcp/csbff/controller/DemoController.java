package com.stubhub.gcp.csbff.controller;

import com.stubhub.gcp.gsbff.model.ResultObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

    @RequestMapping(method = RequestMethod.GET, path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject getResultObject() {
        return new ResultObject("Hello world from JSON - gsapp");
    }
}
