package com.ems.runner;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
//@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	private static Logger logger=Logger.getLogger(MyRunner.class);
	
	@Override
	public void run(String... args) throws Exception {
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		String pwd1=encoder.encode("ravi@123");
		String pwd2=encoder.encode("teja@123");
		String pwd3=encoder.encode("bittu@123");
		
		jdbctemplate.update("insert into mysql_mahadev.users values(?,?,?)" ,"ravi",pwd1,0);
		jdbctemplate.update("insert into mysql_mahadev.users values(?,?,?)" ,"teja",pwd2,1);
		jdbctemplate.update("insert into mysql_mahadev.users values(?,?,?)" ,"bittu",pwd3,1);
		
		jdbctemplate.update("insert into mysql_mahadev.authorities values(?,?)" ,"ROLE_ADMIN","ravi");
		jdbctemplate.update("insert into mysql_mahadev.authorities values(?,?)" ,"ROLE_ADMIN","teja");
		jdbctemplate.update("insert into mysql_mahadev.authorities values(?,?)" ,"ROLE_LEAD","bittu");

	}

}
