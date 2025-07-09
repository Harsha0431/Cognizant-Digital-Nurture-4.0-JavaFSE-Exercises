package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
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

}
