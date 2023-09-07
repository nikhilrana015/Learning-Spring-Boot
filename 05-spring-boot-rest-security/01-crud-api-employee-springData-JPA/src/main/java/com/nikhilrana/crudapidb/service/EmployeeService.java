package com.nikhilrana.crudapidb.service;

import com.nikhilrana.crudapidb.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findEmployeeById(Integer employeeId);

    void deleteEmployeeById(Integer employeeId);

    Employee saveEmployee(Employee employee);

}
