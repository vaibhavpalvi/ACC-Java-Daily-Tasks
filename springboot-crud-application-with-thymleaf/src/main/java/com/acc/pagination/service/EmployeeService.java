package com.acc.pagination.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.acc.pagination.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(int id);
	void deleteEmployeeById(int id);
	Page<Employee> findPaginated(int pageNo, int pageSize);
}
