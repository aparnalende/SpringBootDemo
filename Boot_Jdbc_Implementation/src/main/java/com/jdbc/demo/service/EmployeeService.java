package com.jdbc.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdbc.demo.model.Employee;
@Service
public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee>employees);
	void getAllEmployees();
	void getEmployeeById(String empid);
}
