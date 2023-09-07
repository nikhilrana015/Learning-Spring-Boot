package com.nikhilrana.thymeleafcrud.controller;

import com.nikhilrana.thymeleafcrud.entity.Employee;
import com.nikhilrana.thymeleafcrud.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	// used to bind the employee object.
	@GetMapping("/formToAdd")
	public String addNewEmployee(Model theModel) {

		Employee employee = new Employee();

		theModel.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		employeeService.save(employee);

		// using redirect to prevent duplicate data. If we reload it then it will add duplicate data
		// again and again

		return "redirect:/employees/list";
	}

	@GetMapping("/formToUpdate")
	public String updateEmployee(Model theModel, @RequestParam("employeeId") int employeeId) {

		Employee employee = employeeService.findById(employeeId);

		theModel.addAttribute("employee", employee);

		return "employees/update-employee-form";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int employeeId) {

		employeeService.deleteById(employeeId);

		return "redirect:/employees/list";

	}
}









