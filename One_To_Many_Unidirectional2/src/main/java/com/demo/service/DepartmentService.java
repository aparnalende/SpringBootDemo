package com.demo.service;

import org.springframework.stereotype.Component;

import com.demo.model.Department;

@Component
public interface DepartmentService {

	public Department saveDept(Department department);
	public Department findByDeptId(int deptId);
}
