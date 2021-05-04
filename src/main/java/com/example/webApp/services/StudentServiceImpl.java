package com.example.webApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webApp.model.Student;
import com.example.webApp.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository repo;
	
	@Override
	public Student addStudent(Student s) {
		return repo.save(s);
	}

	@Override
	public Student updateStudent(Student student) {
		 Optional < Student > dBStudent = this.repo.findById(student.getId());

	        if (dBStudent.isPresent()) {
	        	Student studentUpdate = dBStudent.get();
	        	studentUpdate.setId(student.getId());
	        	studentUpdate.setName(student.getName());
	        	studentUpdate.setEmail(student.getEmail());
	        	studentUpdate.setPassword(student.getPassword());
	        	repo.save(studentUpdate);
	            return studentUpdate;
	        } else {
	             System.out.println("Record not found with id : " + student.getId());
	             return null;
	        }

	}

	@Override
	public List<Student> listStudent() {
		return repo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		Optional < Student > studentdb = repo.findById(id);

        if (studentdb.isPresent()) {
            return studentdb.get();
        } else {
            System.out.println("Record not found with id : " + id);
            return null;
        }
	}

	@Override
	public void deleteStudent(int id) {
		Optional < Student > studentdb = repo.findById(id);
        this.repo.delete(studentdb.get());		
	}

	@Override
	public Student getStudentByEmail(String email) {
		Optional < Student > studentdb = repo.findByEmail(email);

        if (studentdb.equals(email)) {
            return studentdb.get();
        } else {
            System.out.println("Record not found with email : " + email);
            return null;
        }
}

	@Override
	public Student getStudentByPassword(String password) {
		Optional < Student > studentdb = repo.findByEmail(password);

        if (studentdb.equals(password)) {
            return studentdb.get();
        } else {
            return null;
        }
}

}
