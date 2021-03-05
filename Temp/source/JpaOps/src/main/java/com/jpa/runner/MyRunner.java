package com.jpa.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.entity.Employee;
import com.jpa.repository.EmployeeRepository;
@Component
public class MyRunner implements CommandLineRunner {
	
	@Autowired
	EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		/*Employee employee=new Employee();
		employee.setDepartment("Projectteam1");
		employee.setName("Ujwal");
		employee.setPtplId(204);
		employee.setSalary(260000);
		repo.saveAndFlush(employee);
		*/
		/*
		Optional<Employee> opt=repo.findById(315);
		if(opt.isPresent())
		{
			Employee e=opt.get();
			System.out.println(e.getName()+" "+e.getSalary()+" "+e.getDepartment() +" " +e.getPtplId() );
		}
		else
		{
			System.out.println("Invalid Id");
		}
		*/
		
		/*List<Employee> list=repo.findAll();
		list.forEach(e->{
			System.out.println(e.getName()+" "+e.getSalary()+" "+e.getDepartment() +" " +e.getPtplId() );
		});
		
		try
		{
	
		repo.deleteById(315);
		}
		catch (Exception e) {
			System.out.println("The Exception was Caught " +e.getMessage());
			
		}*/
	/*	
		List<Employee> list=repo.findByPtplId(304);
		list.forEach(e->{
			System.out.println(e.getName()+" "+e.getSalary()+" "+e.getDepartment() +" " +e.getPtplId() );
		});
	*/
		try
		{
		List<Employee> list=repo.fetchEmpsBySal(30000.0);
		list.forEach(e->{
			System.out.println(e.getName()+" "+e.getSalary()+" "+e.getDepartment() +" " +e.getPtplId() );
		});
		}
		catch (Exception e) {
			System.out.println("Exception Handled : " +e.getMessage());
		}
		
	}
	

}
