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
<<<<<<< HEAD
        return new ResultObject("Hello world from JSON - gsapp");
=======
        return new ResultObject("Hello world from JSON - csapp");
>>>>>>> 3bd4ccc29381d5be3b7dc81b09d0b1a8176a8b15
    }
}
