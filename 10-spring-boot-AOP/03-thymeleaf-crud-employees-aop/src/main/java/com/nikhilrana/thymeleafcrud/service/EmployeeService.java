package com.nikhilrana.thymeleafcrud.service;

import java.util.List;

import com.nikhilrana.thymeleafcrud.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
