package com.acc.paginationandsorting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acc.paginationandsorting.model.Employee;
import com.acc.paginationandsorting.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveemployee")
	public int postEmployeeData(@RequestBody Employee employee) {
		employeeService.saveOrUpdate(employee);
		return employee.getId();
	}
	
	@GetMapping
	private List<Employee> getAllEmployees(){
		return employeeService.getAllBooks();
	}
	
	@GetMapping("/pageing/{offset}/{pageSize}")
	private List<Employee> findEmployeeWithPage(@PathVariable int offset, @PathVariable int pageSize){
		
		Page<Employee> employeeWithPage = employeeService.findEmployeeWithPage(offset, pageSize);
		return employeeWithPage.getContent();
		
	}
	
	@GetMapping("/pagewithsortingasc/{offset}/{pageSize}/{field}")
	private List<Employee> getPaginationWithSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
		Page<Employee> employeeWithPaginationandSorting = employeeService.findPageEmployeeWithPageAndSorting(offset, pageSize, field);
		return employeeWithPaginationandSorting.getContent();
	}
	
	@GetMapping("/pagewithsortingdesc/{offset}/{pageSize}/{field}")
	private List<Employee> getPaginationWithSortingindesc(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
		Page<Employee> employeeWithPaginationandSorting = employeeService.findPageEmployeeWithPageAndSortingindecending(offset, pageSize, field);
		return employeeWithPaginationandSorting.getContent();
	}
	
	
}
