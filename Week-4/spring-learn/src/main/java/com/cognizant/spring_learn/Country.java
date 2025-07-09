package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger logger = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    public Country() {
        logger.debug("Inside Country Constructor.");
    }

    // Getters and Setters
    public String getCode() {
        logger.debug("Inside country.getCode()");
        return code;
    }

    public void setCode(String code) {
        logger.debug("Inside country.setCode()");
        this.code = code;
    }

    public String getName() {
        logger.debug("Inside country.getName()");
        return name;
    }

    public void setName(String name) {
        logger.debug("Inside country.setName()");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Code: " + code + "\tName: " + name;
    }
}