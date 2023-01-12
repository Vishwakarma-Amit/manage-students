package com.student.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.api.entity.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
	
	List<Student> findByName(String name);
	
	Student findByNameAndEmail(String name, String email);
	
	List<Student> findByNameOrEmail(String name, String email);
	
	List<Student> findByDepartmentDepartmentName(String departmentName);
	
	List<Student> findBySubjectsSubjectName(String subjectName);
	
	List<Student> findByEmailIsLike(String email);
	
	List<Student> findByNameStartsWith(String name);
 
}
