package com.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee>  findByDeptNumber(Integer deptNumber);
	
	@Query("select e from  Employee e where e.empSal > ?1")
	List<Employee>  fetchEmpsBySal(double sal);

}
