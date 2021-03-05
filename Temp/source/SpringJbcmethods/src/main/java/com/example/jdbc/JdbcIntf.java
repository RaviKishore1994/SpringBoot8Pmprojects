package com.example.jdbc;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface JdbcIntf {
	
	void execute(int Id,String Name,String Role,long Salary );
	List fetch();

}
