package com.acc.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.acc.pagination.model.Employee;
import com.acc.pagination.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHome(Model model) {
		model.addAttribute("listemployees", employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/shownewemployee")
	public String shownewemployee(Model model) {
	   Employee employee = new Employee();
	   model.addAttribute("employee", employee);
	   return "new_employee";
	}
	
	@PostMapping("/saveemployee")
	public String saveEmp(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String updateEmployee(@PathVariable (value = "id") int id, Model model) {
		Employee employee =employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteemployee/{id}")
	public String deletEmployee(@PathVariable (value = "id") int id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
//	@GetMapping("/page/{pageNo}")
//	public String findPaginated(@PathVariable (value = "pageNo") int PageNo, Model model) {
//		int pageSize = 5;
//		
//		Page<Employee> page = employeeService.findPaginated(PageNo, pageSize);
//		List<Employee> listEmployees = page.getContent();
//		
//		model.addAttribute("cuurentPage", PageNo);
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
//		model.addAttribute("listEmployees", listEmployees);
//		
//		return "index";
//	}
}
