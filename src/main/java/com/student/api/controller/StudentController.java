package com.student.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.api.entity.Student;
import com.student.api.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> registerStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.createStudent(student), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Student>> getStudentList(){
		return new ResponseEntity<List<Student>>(studentService.getStudentList(), HttpStatus.OK);
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudentDetails(@PathVariable String studentId){
		return new ResponseEntity<Student>(studentService.getStudentDetails(studentId), HttpStatus.OK);
	}
	
	@PutMapping("/{studentId}")
	public ResponseEntity<Student> getStudentDetails(@PathVariable String studentId, @RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudentDetails(studentId, student), HttpStatus.OK);
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<String> deleteStudentDetails(@PathVariable String studentId){
		return new ResponseEntity<String>(studentService.deleteStudent(studentId), HttpStatus.OK);
	}
	
	@GetMapping("/findByName/{name}")
	public ResponseEntity<List<Student>> getStudentDetailsByName(@PathVariable String name){
		return new ResponseEntity<List<Student>>(studentService.getStudentDetailsByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/findByNameAndEmail")
	public ResponseEntity<Student> getStudentDetailsByNameAndEmail(@RequestParam String name, @RequestParam String email){
		return new ResponseEntity<Student>(studentService.getStudentByNameAndEmail(name, email), HttpStatus.OK);
	}
	
	@GetMapping("/findByNameOrEmail")
	public ResponseEntity<List<Student>> getStudentDetailsByNameOrEmail(@RequestParam String name, @RequestParam String email){
		return new ResponseEntity<List<Student>>(studentService.getStudentByNameOrEmail(name, email), HttpStatus.OK);
	}
	
	@GetMapping("/allWithPagination")
	public ResponseEntity<List<Student>> getAllWithPagination(@RequestParam int pageNo, @RequestParam int size){
		return new ResponseEntity<List<Student>>(studentService.getAllWithPagination(pageNo, size), HttpStatus.OK);
	}
	
	@GetMapping("/sortedList")
	public ResponseEntity<List<Student>> getSortedStudentList(){
		return new ResponseEntity<List<Student>>(studentService.getSortedStudentList(), HttpStatus.OK);
	}
	
	
	@GetMapping("/emailLike")
	public List<Student> getStudentListByEmail(@RequestParam String email){
		return studentService.getStudentsByEmailLike(email);
	}
	
	@GetMapping("/nameStartsWith")
	public List<Student> getStudentListByNameStartsWith(@RequestParam String name){
		return studentService.getStudentsByNameStartsWith(name);
	}
	
	@GetMapping("/byDepartmentId")
	public List<Student> getStudentListByDepartmentId(@RequestParam String departmentId){
		return studentService.getStudentsByDepartmentId(departmentId);
	}
	
}
