package com.first.demo.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/subjects")
	public List<Subject>allSubject(){
		return subjectService.getAllSubjects();
	}
	
	@RequestMapping("subjects/{code}")
	public Subject getSubject(@PathVariable int code) {
		return subjectService.getSubject(code);
	}
	
	@PostMapping("subjects")
	public 	void addSubject(@RequestBody Subject subject) {
		subjectService.addSubject(subject);
	}
	
	@PutMapping("subjects/{code}")
	public void updateSubject(@RequestBody Subject subject,@PathVariable int code) {
		subjectService.updateSubject(subject,code);
	}
	@DeleteMapping("subjects/{code}")
	public void deleteSubject(@PathVariable int code) {
		subjectService.deleteSubject(code);
	}
}
