package com.customer.breaker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class CircuitBreaker {
	
	private  static String  FRIEND_URL="http://MSFRIEND/FriendApi/{phoneNumber}";
	
	@Autowired
	@Qualifier("restTempl")
	RestTemplate  restTemplate2;
	
	@HystrixCommand(fallbackMethod = "getFriendsContactsFallback")
	public  List<Long>  getFriendsContacts(Long phoneNumber) {
		ParameterizedTypeReference<List<Long>>   typeRef=new  ParameterizedTypeReference<List<Long>>() {};
		ResponseEntity<List<Long>> re = restTemplate2.exchange(FRIEND_URL, HttpMethod.GET, null, typeRef, phoneNumber);
		List<Long> friendsContactList = re.getBody();	
		return  friendsContactList;
	}
	
	public  List<Long>  getFriendsContactsFallback(Long  phoneNumber) {
		return  new ArrayList<Long>();
	}

}
