package com.students.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.students.model.Student;
import com.students.repository.StudentRepository;
import com.students.service.StudentService;

@RestController
public class StudentRestController {

	@Autowired
	StudentService service;
	StudentRepository repo;
	
	
	//add student
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	
	//find all students
	@GetMapping("/students")
	public List<Student> findAllStudent() {
		List<Student> students = service.findAllStudents();
		return students;
	}
	
	
	//find student by id
	@GetMapping("/students/{id}")
	public Optional<Student> logoutStudent(@PathVariable long id) {
		return service.findStudentById(id); 
	}
	
	
	//update students
	@PutMapping("/students/{id}")
	public Student updateStudents(@RequestBody Student student,@PathVariable long id) {
		return service.updateStudent(student, id);
	}
	
	
	@DeleteMapping("/students/{id}")
	public String deleteStudents(@PathVariable long id) {
		service.deleteStudent(id);
		return "student deleted successfully";
	}
	
}
