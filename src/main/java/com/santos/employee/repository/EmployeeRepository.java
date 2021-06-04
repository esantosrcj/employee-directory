package com.santos.employee.repository;

import com.santos.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findAllByOrderByLastNameAsc();
}