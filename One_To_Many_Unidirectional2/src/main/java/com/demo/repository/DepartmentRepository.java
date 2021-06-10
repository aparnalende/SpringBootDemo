package com.demo.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Serializable> {

	public Department findByDeptId(int deptId);
}


