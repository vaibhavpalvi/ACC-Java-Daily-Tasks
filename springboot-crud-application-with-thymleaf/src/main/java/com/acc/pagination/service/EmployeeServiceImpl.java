package com.acc.pagination.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.acc.pagination.model.Employee;
import com.acc.pagination.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> optional =employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			
			employee = optional.get();
			
		} else {
			throw new RuntimeException("Employee_id_not_found");
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(int id) {
		
		this.employeeRepository.deleteById(id);
		
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return this.employeeRepository.findAll(pageable);
	}

}
