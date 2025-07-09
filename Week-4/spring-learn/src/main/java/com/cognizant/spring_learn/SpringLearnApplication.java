package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		// displayDate();
		// displayDateWithLogger();
		displayCountry();
	}

	private static void displayDate(){
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat dateFormat = context.getBean("dateFormat", SimpleDateFormat.class);
		try{
			Date date = dateFormat.parse("31/12/2018");
			System.out.println(date);
			System.out.println("Parsed Date: " + date);
		}
		catch (Exception e){
			System.out.println("Failed to format date due to " + e);
		}
	}

	private static void displayDateWithLogger(){
		logger.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat dateFormat = context.getBean("dateFormat", SimpleDateFormat.class);
		try{
			Date date = dateFormat.parse("31/12/2018");
			logger.info(date.toString());
		}
		catch (Exception e){
			logger.error(e.toString());
			System.out.println("Failed to format date due to " + e);
		}
		logger.info("End");
	}

	private static void displayCountry(){
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = context.getBean("country", Country.class);
		logger.debug("Country: {}", country);
	}
}
