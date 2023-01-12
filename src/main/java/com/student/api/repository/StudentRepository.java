package com.student.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.api.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
	
	List<Student> findByName(String name);
	
	Student findByNameAndEmail(String name, String email);
	
	List<Student> findByNameOrEmail(String name, String email);
	
	List<Student> findByEmailIsLike(String email);
	
	List<Student> findByNameStartsWith(String name);
	
	List<Student> findByDepartmentDepartmentId(String departmentId);
	
	@Query("{\"name\" : \"?0\"}")
	List<Student> getByName(String name);
 
}
