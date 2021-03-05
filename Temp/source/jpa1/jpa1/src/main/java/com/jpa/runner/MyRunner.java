package com.jpa.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.entity.Employee;
import com.jpa.repository.EmployeeRepository;

@Component
public class MyRunner implements CommandLineRunner {
	
	@Autowired
	EmployeeRepository  repo;

	@Override
	public void run(String... args) throws Exception {
		/*
		Employee  e=new Employee();
		e.setEmpNumber(7589);
		e.setEmpName("JATIN");
		e.setEmpSal(9000.0);
		e.setDeptNumber(20);
		repo.saveAndFlush(e);
		*/
		
		/*
		Optional<Employee>  opt= repo.findById(7788);
		if(opt.isPresent()) {
			Employee e= opt.get();
			System.out.println(e.getEmpNumber()+"  "+e.getEmpName()+"  "+e.getEmpSal()+"  "+e.getDeptNumber());
		}
		*/
		
		/*
		List<Employee> empList = repo.findAll();
		empList.forEach( e -> {
			System.out.println(e.getEmpNumber()+"  "+e.getEmpName()+"  "+e.getEmpSal()+"  "+e.getDeptNumber());
		});
		*/
		
		/*
		List<Employee> empList = repo.findByDeptNumber(30);
		empList.forEach( e -> {
			System.out.println(e.getEmpNumber()+"  "+e.getEmpName()+"  "+e.getEmpSal()+"  "+e.getDeptNumber());
		});
		*/
		
		List<Employee> empList = repo.fetchEmpsBySal(5500.0);
		empList.forEach( e -> {
			System.out.println(e.getEmpNumber()+"  "+e.getEmpName()+"  "+e.getEmpSal()+"  "+e.getDeptNumber());
		});
		
		
		

	}

}
