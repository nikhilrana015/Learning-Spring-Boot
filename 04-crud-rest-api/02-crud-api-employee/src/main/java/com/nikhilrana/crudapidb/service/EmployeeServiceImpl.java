package com.nikhilrana.crudapidb.service;

import com.nikhilrana.crudapidb.dao.EmployeeDAO;
import com.nikhilrana.crudapidb.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findEmployeeById(Integer employeeId) {
        return employeeDAO.findEmployeeById(employeeId);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(Integer employeeId) {
        employeeDAO.deleteEmployeeById(employeeId);
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }
}
