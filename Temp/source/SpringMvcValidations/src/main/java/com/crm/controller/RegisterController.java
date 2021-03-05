package com.crm.controller;

import javax.naming.spi.DirStateFactory.Result;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.crm.dao.IRegisterDao;
import com.crm.model.CustomerBean;
import com.crm.service.EmailService;
@Controller
public class RegisterController {
	
	@Autowired
	EmailService emailService;
	@Autowired
	IRegisterDao registerDao;
	
	@GetMapping("/index")
	public String getIndexPage()
	{
		return "index";
	}
	@GetMapping("/register")
	public String getRegisterPage(Model model)
	{
		CustomerBean bean=new CustomerBean();
		model.addAttribute("custBean", bean);
		return "register";
	}
	
	@PostMapping("/save")
	public String registerCustomer(@Valid @ModelAttribute("CustBean")CustomerBean customerbean,BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "register";
		}
		else
		{
			boolean flag=registerDao.saveCustomer(customerbean);
			if(flag==false)
			{
				model.addAttribute("message", "A Customer has already Registered");
			return "register";
			}
			else
			{
				String name=customerbean.getFirstName()+" "+customerbean.getLastName();
				emailService.sendEmailToCustomer(customerbean.getEmail(),name);
				return "registrationSuccess";
			}
			
			
			
		}
	}
	
	

}
