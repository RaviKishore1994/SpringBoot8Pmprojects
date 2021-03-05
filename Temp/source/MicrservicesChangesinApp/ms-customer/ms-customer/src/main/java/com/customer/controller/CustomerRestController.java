package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.circuitbreaker.CircuitBreaker;
import com.customer.dto.CustomerDto;
import com.customer.dto.LoginDTO;
import com.customer.dto.PlanDTO;
import com.customer.dto.RegisterDTO;
import com.customer.service.ICustomerService;

@RestController
@RibbonClient(name="custribbon")
public class CustomerRestController {
	@Autowired
	ICustomerService  service;
	
	@Autowired
	CircuitBreaker breaker;
	
	@Autowired
	@Qualifier("restTemp")
	RestTemplate restTemplate;
	
	@Autowired
	@Qualifier("restTempl")
	RestTemplate  loadBalancedRestTemplate;
	
//	private static String PLAN_URL = "http://localhost:4242/PlanApi/{planId}";
//	private static String FRIEND_URL = "http://custribbon/FriendApi/{phoneNumber}";
//	private static String FRIEND_URL = "http://localhost:4343/FriendApi/{phoneNumber}";
	private static String PLAN_URL = "http://msplandetails/PlanApi/{planId}";
	private static String FRIEND_URL = "http://msfrienddetails/FriendApi/{phoneNumber}";
	
	@PostMapping("/register")
	public boolean  addCustomer(@RequestBody RegisterDTO  registerDto) {
		return service.registerCustomer(registerDto);
	}
	
	@PostMapping("/login")
	public  boolean  loginCustomer(@RequestBody  LoginDTO loginDto) {
		return  service.loginCustomer(loginDto);
	}
	
	@GetMapping("/viewProfile/{phoneNumber}")
	public  CustomerDto  showProfile(@PathVariable Long phoneNumber) {
		CustomerDto  customerDto=service.readCustomer(phoneNumber);
		//calling plan microservice
		PlanDTO planDto = loadBalancedRestTemplate.getForObject(PLAN_URL, PlanDTO.class, customerDto.getPlanId());
		customerDto.setCurrentPlan(planDto);
		
		//calling friend microservice
	//	List<Long> friendsContactNumbers = loadBalancedRestTemplate.getForObject(FRIEND_URL, List.class, phoneNumber);
		
	//	List<Long> friendsContactNumbers = restTemplate.getForObject(FRIEND_URL, List.class, phoneNumber);
		
		List<Long> friendsContactNumbers=breaker.getFriendsContacts(phoneNumber);
		customerDto.setFriendsContactNumbers(friendsContactNumbers);
		
		return customerDto;
		
	}
	
}
