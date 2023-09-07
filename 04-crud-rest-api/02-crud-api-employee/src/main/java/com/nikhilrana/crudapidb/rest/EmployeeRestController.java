package com.nikhilrana.crudapidb.rest;

import com.nikhilrana.crudapidb.dao.EmployeeDAO;
import com.nikhilrana.crudapidb.entity.Employee;
import com.nikhilrana.crudapidb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {

        List<Employee> employees = employeeService.findAll();
        return employees;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId) {

        Employee employee = employeeService.findEmployeeById(employeeId);

        if(employee == null) {
            throw new RuntimeException("Employee with id " + employeeId + " is not found");
        }

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId) {

        employeeService.deleteEmployeeById(employeeId);
        return;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        Employee updatedEmployee = employeeService.saveEmployee(employee);

        if(updatedEmployee == null) {
            throw new RuntimeException("Employee with id " + employee.getId() + " is not found");
        }

        return updatedEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setId(0);
        Employee dbEmployee = employeeService.saveEmployee(employee);
        return dbEmployee;
    }

}
