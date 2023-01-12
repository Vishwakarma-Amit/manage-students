package com.student.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.student.api.entity.Student;
import com.student.api.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudentList() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentDetails(String studentId) {
		return studentRepository.findById(studentId).orElseThrow(()-> new RuntimeException("Student not found!!"));
	}

	@Override
	public Student updateStudentDetails(String studentId, Student student) {
		Student studentDetails = getStudentDetails(studentId);
		studentDetails.setName(student.getName()!=null?student.getName():studentDetails.getName());
		studentDetails.setEmail(student.getEmail()!=null?student.getEmail():studentDetails.getEmail());
		studentDetails.setDepartment(student.getDepartment()!=null?student.getDepartment():studentDetails.getDepartment());
		studentDetails.setSubjects(student.getSubjects()!=null?student.getSubjects():studentDetails.getSubjects());
		return studentRepository.save(studentDetails);
	}

	@Override
	public String deleteStudent(String studentId) {
		Student student = getStudentDetails(studentId);
		if(student!=null) {
			studentRepository.deleteById(student.getStudentId());
			return "Student deleted successfully!!";
		}else {
			return "No student found!!";
		}
	}

	@Override
	public List<Student> getStudentDetailsByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public Student getStudentByNameAndEmail(String name, String email) {
		return studentRepository.findByNameAndEmail(name, email);
	}

	@Override
	public List<Student> getStudentByNameOrEmail(String name, String email) {
		return studentRepository.findByNameOrEmail(name, email);
	}

	@Override
	public List<Student> getAllWithPagination(int pageNo, int size) {
		PageRequest pageable = PageRequest.of(pageNo-1, size);
		return studentRepository.findAll(pageable).getContent();
	}

	@Override
	public List<Student> getSortedStudentList() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name", "email");
		return studentRepository.findAll(sort);
	}

	@Override
	public List<Student> getStudentsByDepartmentName(String departmentName) {
		return studentRepository.findByDepartmentDepartmentName(departmentName);
	}

	@Override
	public List<Student> getStudentsBySubjectName(String subjectName) {
		return studentRepository.findBySubjectsSubjectName(subjectName);
	}

	@Override
	public List<Student> getStudentsByEmailLike(String email) {
		return studentRepository.findByEmailIsLike(email);
	}

	@Override
	public List<Student> getStudentsByNameStartsWith(String name) {
		return studentRepository.findByNameStartsWith(name);
	}
	
}
