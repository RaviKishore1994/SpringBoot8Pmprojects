package com.customer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customer.dto.PlanDTO;

@Component
@FeignClient("MSPLAN")
public interface PlanFeign {
	
	@RequestMapping("/PlanApi/{planId}")
	PlanDTO   getPlanDetails(@PathVariable String planId);

}
