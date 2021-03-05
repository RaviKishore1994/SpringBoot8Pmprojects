package com.customer.circuitbreaker;

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

	private static String FRIEND_URL="http://localhost:4343/FriendApi/{phoneNumber}";
	
	@Autowired
	@Qualifier("restTemp")
	RestTemplate restTemplate2;
	
	@HystrixCommand(fallbackMethod="getFriendContactsFallBack")
	public List<Long> getFriendsContacts(Long PhoneNumber){
		ParameterizedTypeReference<List<Long>> typeRef=new ParameterizedTypeReference<List<Long>>() {};
	ResponseEntity<List<Long>> re=restTemplate2.exchange(FRIEND_URL, HttpMethod.GET, null, typeRef, PhoneNumber);
	
	List<Long> friendsContactList=re.getBody();
	return friendsContactList;
		
			
	}
	public List<Long> getFriendContactsFallBack(Long PhoneNumber)
	{
		return new ArrayList<Long>();
		
	}
	
	
	
}
