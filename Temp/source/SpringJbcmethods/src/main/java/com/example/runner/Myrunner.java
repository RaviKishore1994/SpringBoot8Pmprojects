package com.example.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.jdbcimp.Methodimpl;
@Component
public class Myrunner implements CommandLineRunner {

	@Autowired
	Methodimpl method;
	@Override
	public void run(String... args) throws Exception {
		try
		{
			
		
		method.execute(23, "Teja", "developer", 500000);
		System.out.println("Record were inserted");
		List list=method.fetch();

		
		System.out.println("The Inserted list  is  : " +list);
		}
		catch (Exception e) {
			System.out.println("The exception occured " +e.getMessage());
		}
	}

}
