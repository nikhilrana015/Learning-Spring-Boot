package com.nikhilrana.crudapidb.dao;

import com.nikhilrana.crudapidb.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee>findAll();

    Employee findEmployeeById(Integer employeeId);

    void deleteEmployeeById(Integer employeeId);

    Employee saveEmployee(Employee employee);

}
