package com.nikhilrana.thymeleafcrud.dao;

import com.nikhilrana.thymeleafcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!

    // sort the data based on firstName
    public List<Employee> findAllByOrderByFirstNameAsc();
}
