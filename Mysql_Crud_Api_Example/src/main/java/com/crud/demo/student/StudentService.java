package com.crud.demo.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public List<StudentEntity> getAllStudents(){
		List<StudentEntity> students=new ArrayList<StudentEntity>();
		repository.findAll().forEach(e->students.add(e));
		return students;
	}

	public StudentEntity getStudentById(Long id) throws RecordNotFoundException{
		Optional<StudentEntity>student=repository.findById(id);

		if(student.isPresent()) {
			return student.get();
		}
		else
		{
			throw new RecordNotFoundException("No student record exists for given id !!!", id);
		}
	}

	public StudentEntity createOrUpdateStudent(StudentEntity entity) throws RecordNotFoundException{
		if(entity.getId()!=null) {
			Optional<StudentEntity> student=repository.findById(entity.getId());

			if(student.isPresent())
			{
				StudentEntity newEntity=student.get();
				newEntity.setEmailId(entity.getEmailId());
				newEntity.setFirstName(entity.getFirstName());
				newEntity.setLastName(entity.getLastName());
				newEntity.setBranch(entity.getBranch());
				newEntity=repository.save(newEntity);

				return newEntity;
			}
			else
			{
				entity=repository.save(entity);
				return entity;
			}
		}
		else
		{
			entity=repository.save(entity);
			return entity;
		}
	}

	public void deleteStudentById(Long id) throws RecordNotFoundException{
		Optional<StudentEntity>student=repository.findById(id);

		if(student.isPresent()) {
			repository.deleteById(id);
		}
		else
		{
			throw new RecordNotFoundException("No record exist for given id !!!", id);
		}
	}

	public List<StudentEntity> getAllStudentsByBranch(String brname){
		System.out.println("Service "+brname);
		List<StudentEntity>studentList=repository.findByBranch(brname);
		if(studentList.size()>0) {
			return studentList;
		}else
		{
			return new ArrayList<StudentEntity>();
		}
	}
}
