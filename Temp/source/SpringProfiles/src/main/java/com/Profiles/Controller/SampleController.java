package com.Profiles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Profiles.Bean.SampleBean;

@RestController
public class SampleController {
	
	@Autowired
	SampleBean bean;

	@GetMapping("/mapping")
 public String displayBean()
 {
	 return bean.getBean();
 }

}
