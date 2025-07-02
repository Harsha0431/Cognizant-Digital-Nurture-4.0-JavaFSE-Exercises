package com.cognizant.orm_learn;

import com.cognizant.orm_learn.handson_4.model.Employee;
import com.cognizant.orm_learn.handson_4.service.EmployeeService;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories(basePackages = {"com.cognizant.orm_learn.repository", "com.cognizant.orm_learn.handson_4.repository"})
@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {
	@Autowired
	private CountryService countryService;
	@Autowired
	private EmployeeService employeeService;
	private static final Logger  logger = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
		logger.info("Inside main");
	}

	private void testGetAllCountries() {
        logger.info("Start");
        List<Country> countries = countryService.getAllCountries();
        logger.debug("countries={}", countries);
        logger.info("End");
    }

	@Override
	public void run(String... args) throws Exception {
		logger.info("Inside run()");
        // testGetAllCountries();
		testJpa();
	}

	private void testHibernateDemo(){
		Employee emp = new Employee("Harsha");
		long id = employeeService.addEmployeeHibernate(emp);
		logger.debug("Saved employee data with ID {}", id);
	}

	private void testJpa(){
		Employee emp = new Employee("JPA Employee");
		long id = employeeService.addEmployeeJpa(emp);
		logger.debug("Saved employee data using JPA with ID {}", id);
	}
}
