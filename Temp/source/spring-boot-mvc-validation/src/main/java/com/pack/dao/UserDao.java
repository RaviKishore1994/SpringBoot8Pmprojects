package com.pack.dao;

import java.util.List;

import com.pack.bean.Country;
import com.pack.bean.UserBean;

public interface UserDao {
	List<Country>   getAllCountries();
	boolean   saveUser(UserBean  userBean);
}
