package com.ems.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
public class MyRunner implements CommandLineRunner {
	
	@Autowired
	JdbcTemplate  jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		String pwd1=encoder.encode("anshu@1211");
		String pwd2=encoder.encode("ram@n181");
		String pwd3=encoder.encode("bhuvi_108");
		
		jdbcTemplate.update("insert into users values(?,?,?)", "anshu", pwd1, 0);
		jdbcTemplate.update("insert into users values(?,?,?)", "raman", pwd2, 1);
		jdbcTemplate.update("insert into users values(?,?,?)", "bharat", pwd3, 1);
		
		jdbcTemplate.update("insert into authorities values(?,?)", "ROLE_ADMIN", "anshu");
		jdbcTemplate.update("insert into authorities values(?,?)", "ROLE_LEAD", "raman");
		jdbcTemplate.update("insert into authorities values(?,?)", "ROLE_ADMIN", "bharat");
		
	}

}
