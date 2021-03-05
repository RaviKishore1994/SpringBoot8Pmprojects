package com.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp2")
public class Employee {
	
	@Id
	@Column(name="empno")
	private Integer ptplId;
	
	@Column(name="dept")
	private String department;
	
	@Column(name="sal")
	private double salary;
	
	@Column(name="empname")
	private String name;

	public Integer getPtplId() {
		return ptplId;
	}

	public void setPtplId(Integer ptplId) {
		this.ptplId = ptplId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
