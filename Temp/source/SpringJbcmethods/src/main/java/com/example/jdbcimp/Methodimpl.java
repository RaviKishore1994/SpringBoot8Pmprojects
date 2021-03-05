package com.example.jdbcimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jdbc.JdbcIntf;
@Repository
public class Methodimpl implements JdbcIntf {

	@Autowired
	JdbcTemplate jdbctemplate;
	@Override
	public void execute(int Id, String Name, String Role, long Salary) {
		
		jdbctemplate.update("insert into empyml values (?,?,?,?)", Id,Name,Role,Salary  );

	}

	@Override
	public List fetch() {
		
		
		return jdbctemplate.queryForList("select * from empyml");
	}

	

}
