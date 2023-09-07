package com.nikhilrana.crudapidb.service;

import com.nikhilrana.crudapidb.dao.EmployeeRepository;
import com.nikhilrana.crudapidb.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll() ;
    }

    @Override
    public Employee findEmployeeById(Integer employeeId) {

        Optional<Employee> result = employeeRepository.findById(employeeId);

        /*
            Optional is used to handle the null. So we check whether
            result is null or not by calling its functions and also get
            the value. Feature comes with Java 8
        */

        Employee employee = null;

        if(result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Employee not found");
        }

        return employee;
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        employeeRepository.deleteById(employeeId); ;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee) ;
    }
}
