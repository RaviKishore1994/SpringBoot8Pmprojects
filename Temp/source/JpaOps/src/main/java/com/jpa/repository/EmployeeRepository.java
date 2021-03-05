package com.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByPtplId(Integer ptplId);
	
	@Query(value="select * from mysql_mahadev.emp2 e  where e.sal>?", nativeQuery=true)
	List<Employee> fetchEmpsBySal(Double sal);

}
