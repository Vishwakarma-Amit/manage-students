package com.student.api.service;

import java.util.List;

import com.student.api.entity.Student;

public interface StudentService {
	
	Student createStudent(Student student);
	
	List<Student> getStudentList();
	
	Student getStudentDetails(String studentId);
	
	Student updateStudentDetails(String studentId, Student student);
	
	String deleteStudent(String studentId);

	List<Student> getStudentDetailsByName(String name);
	
	Student getStudentByNameAndEmail(String name, String email);
	
	List<Student> getStudentByNameOrEmail(String name, String email);

	List<Student> getAllWithPagination(int pageNo, int size);
	
	List<Student> getSortedStudentList();
	
	List<Student> getStudentsByDepartmentName(String departmentName);

	List<Student> getStudentsBySubjectName(String subjectName);

	List<Student> getStudentsByEmailLike(String email);

	List<Student> getStudentsByNameStartsWith(String name);
}
