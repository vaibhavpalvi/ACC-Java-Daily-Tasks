package com.acc.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acc.pagination.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
