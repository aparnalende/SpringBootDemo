package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Department;
import com.demo.service.DepartmentService;

@RestController
@RequestMapping(value="/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value="/saveDepartment",method=RequestMethod.POST)
	@ResponseBody
//	@PostMapping("/saveDepartment")
	public Department saveDepartment(@RequestBody Department department) {
		Department deptResponse=departmentService.saveDept(department);
		return deptResponse;
	}
	
//	@GetMapping("/{deptId}")
	@RequestMapping(value="/{deptId}",method=RequestMethod.GET)
	@ResponseBody
	public Department getDepartmentDetails(@PathVariable int deptId)
	{
		Department deptResponse=departmentService.findByDeptId(deptId);
		return deptResponse;
	}
}
