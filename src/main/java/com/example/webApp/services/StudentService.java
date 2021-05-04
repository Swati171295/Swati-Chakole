package com.example.webApp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.webApp.model.Student;


public interface StudentService {
	public Student addStudent(Student s);
	public Student updateStudent(Student student);
	public List<Student> listStudent();
	public Student getStudentById(int id);
	public Student getStudentByEmail(String email);
	public void deleteStudent(int id);
	public Student getStudentByPassword(String password);

	

}
