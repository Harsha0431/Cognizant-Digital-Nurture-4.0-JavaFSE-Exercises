package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    public String sayHello(){
        logger.info("Start sayHello()");
        try{
            return "Hello World!!";
        }
        catch (Exception e){
            logger.error(e.getMessage());
            return "Failed to say Hello!";
        }
        finally {
            logger.info("End sayHello()");
        }
    }
}
