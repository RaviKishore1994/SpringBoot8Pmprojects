package com.pack.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pack.bean.Country;

public class CountryMapper implements RowMapper<Country> {
	@Override
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
		Country  country=new Country();
		country.setCountryId(rs.getInt(1));
		country.setCountryName(rs.getString(2));
		return country;
	}
}
