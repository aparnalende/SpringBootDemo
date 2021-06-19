package com.jdbc.demo.dao;

import java.util.List;

import com.jdbc.demo.model.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee ins);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(String empId);
}
