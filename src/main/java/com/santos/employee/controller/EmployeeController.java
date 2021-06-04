package com.santos.employee.controller;

import com.santos.employee.model.Employee;
import com.santos.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> employees = this.employeeService.findAll();
		model.addAttribute("employees", employees);

		return "employees/list-employees";
	}

	@GetMapping("/add")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		Employee employee = this.employeeService.findById(id);
		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		this.employeeService.save(employee);

		// Redirect to /employees/list
		return "redirect:/employees/list";
	}


	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		this.employeeService.deleteById(id);

		// Redirect to /employees/list
		return "redirect:/employees/list";
	}
}