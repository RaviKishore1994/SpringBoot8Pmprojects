package com.ems;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
//@PropertySource("classpath:application.properties")
public class EmsApplication  {
	
	private static Logger logger= Logger.getLogger(EmsApplication.class);
	
	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}



}
