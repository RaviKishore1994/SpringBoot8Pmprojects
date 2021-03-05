package com.crm.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerBean {
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Pattern(regexp="^[a-z][a-z0-9#@!]*")
	@Size(min=6,max=16)
	private String password;
	
	@Min(18)
	@Max(45)
	@NotNull
	private int age;
	
	@NotNull
	private Gender gender;
	
	/*for COnversionn of string given in request to datetimeformat*/
	@Past
	@NotNull
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date dob;
	@NotNull
	private Long contactNumber;
	@NotEmpty
	private String country;
	
	private Map<String,String> countries=new HashMap();
	
	public CustomerBean() {
		countries.put("INDIA", "india");
		countries.put("NEPAL", "nepal");
		countries.put("Srilanka", "srilanka");
		
		
		
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Map<String, String> getCountries() {
		return countries;
	}

	public void setCountries(Map<String, String> countries) {
		this.countries = countries;
	}
	
	

}
