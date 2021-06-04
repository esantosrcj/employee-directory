package com.santos.employee.service;

import com.santos.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
	List<Employee> findAll();
	Employee findById(int id);
	void save(Employee employee);
	void deleteById(int id);
}
