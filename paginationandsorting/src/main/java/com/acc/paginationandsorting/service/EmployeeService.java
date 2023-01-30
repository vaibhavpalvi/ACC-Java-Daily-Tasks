package com.acc.paginationandsorting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.acc.paginationandsorting.model.Employee;
import com.acc.paginationandsorting.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	//to get all the data 
	public List<Employee> getAllBooks()   
	{  
	List<Employee> employees = new ArrayList<Employee>();  
	employeeRepository.findAll().forEach(employee1 -> employees.add(employee1));  
	return employees;  
	}
	
	//to post the data
	public void saveOrUpdate(Employee employee)   
	{  
		employeeRepository.save(employee);  
	}
	
	// Pagination and sorting in ascending order
	 public Page<Employee> findPageEmployeeWithPageAndSorting(int offset, int pageSize, String Field){
		 Page<Employee> empoyee = employeeRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Field).ascending()));
		 return empoyee;
	 }
	 
	 
	// Pagination and sorting in descending order
		 public Page<Employee> findPageEmployeeWithPageAndSortingindecending(int offset, int pageSize, String Field){
			 Page<Employee> empoyee = employeeRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Field).descending()));
			 return empoyee;
		 }
	 
	 //paging only
	 public Page<Employee> findEmployeeWithPage(int offset, int pageSize){
		 Page<Employee> employee = employeeRepository.findAll(PageRequest.of(offset, pageSize));
		 return employee;
	 }
	 
	 
}
