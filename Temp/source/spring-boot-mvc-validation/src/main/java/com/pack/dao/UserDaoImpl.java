package com.pack.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pack.bean.Country;
import com.pack.bean.Gender;
import com.pack.bean.UserBean;
import com.pack.mapper.CountryMapper;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	JdbcTemplate  jdbcTemplate;

	@Override
	public List<Country> getAllCountries() {

		return  jdbcTemplate.query("select  * from countries", new CountryMapper());
	}

	@Override
	public boolean saveUser(UserBean userBean) {
		String username=userBean.getUsername();
		String email =userBean.getEmail();
		int  age = userBean.getAge();
		Gender gender=userBean.getGender();
		String  genderValue="";
		if(gender==Gender.MALE) {
			genderValue="M";
		}
		else if(gender==Gender.FEMALE) {
			genderValue="F";
		}
		else {
			genderValue="OTH";
		}
		
		java.util.Date  d1 = userBean.getDob();
		java.sql.Date   dob = new java.sql.Date(d1.getTime());
		
		String country=userBean.getCountry();
		try {
			jdbcTemplate.update("insert  into  registered_users values(?,?,?,?,?,?)", username,email,age,genderValue,dob,country);
			return  true;
		}
		catch(Exception  e) {
			return  false;
		}
		
	}

}
