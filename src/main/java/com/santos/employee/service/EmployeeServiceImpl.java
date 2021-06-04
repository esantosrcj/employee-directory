package com.santos.employee.service;

import com.santos.employee.model.Employee;
import com.santos.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return this.employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = this.employeeRepository.findById(id);
		if (!result.isPresent()) {
			throw new RuntimeException("Employee ID Not Found: " + id);
		}

		return result.get();
	}

	@Override
	public void save(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		this.employeeRepository.deleteById(id);
	}
}
