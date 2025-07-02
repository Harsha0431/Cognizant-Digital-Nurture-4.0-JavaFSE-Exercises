package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries(){
        logger.info("Started fetching countries list");
        return countryRepository.findAll();
    }
}
