package com.students.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.model.Student;
import com.students.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;
	
	
	//add a student
	public Student addStudent(Student student) {
		return repository.save(student); 
	}
	
	
	//find all students
	public List<Student> findAllStudents(){
		List<Student> students = repository.findAll();
		return students;
	}
	
	
	//find a student by id
	public Optional<Student> findStudentById(long id){
		return repository.findById(id);
	}
	
	
	//update a student
	public Student updateStudent(Student student, long id) {
		repository.findById(id);
		return repository.save(student);
	}
	
	
	//delete student by id
	public void deleteStudent(long id) {
		repository.findById(id);
		repository.deleteById(id);
	}
}
