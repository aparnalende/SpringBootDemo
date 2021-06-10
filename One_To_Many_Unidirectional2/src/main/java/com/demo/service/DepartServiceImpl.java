package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Department;
import com.demo.repository.DepartmentRepository;

@Service("deptServiceImpl")
public class DepartServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDept(Department department) {
		// TODO Auto-generated method stub
	department=departmentRepository.save(department);
	return department;
	}

	@Override
	public Department findByDeptId(int deptId) {
		// TODO Auto-generated method stub
		Department department=departmentRepository.findByDeptId(deptId);
		return department;
	}

}
