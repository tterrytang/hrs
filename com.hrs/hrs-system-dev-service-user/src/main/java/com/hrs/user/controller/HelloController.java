package com.hrs.user.controller;

import com.hrs.api.controller.user.HelloControllerApi;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController implements HelloControllerApi {
    final static Logger logger = LoggerFactory.getLogger(HelloController.class);
    // @GetMapping("/Hello")
    public Object hello(){
        logger.debug("debug:hello~");
        return "Hello";
    }
}
