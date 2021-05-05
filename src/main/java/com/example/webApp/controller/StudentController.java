package com.example.webApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.webApp.services.StudentService;
import com.example.webApp.model.Student;
import com.example.webApp.repository.StudentRepository;

@Controller
//@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService     service;

	@RequestMapping(value=" ", method=RequestMethod.GET)
	public String viewHomePage() {
        return "index";
        }
	@RequestMapping(value="/student_list", method=RequestMethod.GET)
	public String listUsers(Model model) {
			List<Student> listStudents = service.listStudent();
			model.addAttribute("listStudents", listStudents);
			return "students";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute("student", new Student());
		return "registration_form";
	}
	@RequestMapping(value="/process_register", method=RequestMethod.POST)
	public String processRegister(Student student) {
		service.addStudent(student);
		return "redirect:/student_list";
	}
	

	 @RequestMapping(value="/login", method=RequestMethod.GET)
		public String showLoginForm(Model model) {
			 model.addAttribute("student", new Student());
			 return "login";
	 }	
	 @RequestMapping(value="/logged_in", method=RequestMethod.POST)
		public String loginsuccess(Student student) {
		 service.getStudentByEmail(student.getEmail());
		 service.getStudentByPassword(student.getPassword());
		 
		 return "login_success";
		}	
	 
	 //@GetMapping("/edit/{id}")
	 @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	 public String showEditStudentPage(@PathVariable (value = "id") Integer id , Model model) {
		 Student student= service.getStudentById(id);
		 model.addAttribute("student" , student);
		 return "edit_student";
	 }
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public String deleteStudent(@PathVariable (value = "id") Integer id) {
		 this.service.deleteStudent(id);
		 return "redirect:/student_list";
	 }
	
}

