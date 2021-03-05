package com.crm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crm.dao.IRegisterDao;
import com.crm.model.CustomerBean;
@Repository
public class RegisterDaoImpl implements IRegisterDao {
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Override
	public boolean saveCustomer(CustomerBean customerbean) {

		int count=jdbctemplate.queryForObject("select count(*) from mysql_mahadev.customer_tab where email=?", Integer.class,customerbean.getEmail() );
		if(count==1)
		{
			return false;
		}
		else
		{
			jdbctemplate.update("insert into mysql_mahadev.customer_tab values (?,?,?,?,?,?,?)",customerbean.getFirstName(),customerbean.getLastName(),customerbean.getAge(),customerbean.getContactNumber(),customerbean.getDob(),customerbean.getEmail(),customerbean.getPassword(),customerbean.getGender(),customerbean.getCountry() );
		
			return true;
		}
		
		
		
	}

}
