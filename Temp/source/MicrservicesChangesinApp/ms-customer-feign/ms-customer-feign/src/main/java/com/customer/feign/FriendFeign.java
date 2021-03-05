package com.customer.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient("MSFRIEND")
public interface FriendFeign {
	
	@RequestMapping("/FriendApi/{phoneNumber}")
	List<Long>  getFriends(@PathVariable Long phoneNumber);

}
