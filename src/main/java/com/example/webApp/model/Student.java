package com.example.webApp.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL , fetch=FetchType.LAZY , mappedBy = "students")
	private Mark marks;
	
	/*@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="m_id", referencedColumnName= "m_id")
	private Mark marks;*/

	public Student() {
		
	}
	
	public Student(int id, String name, String email, String password, Mark marks) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.marks = marks;
	}

	public Mark getMarks() {
		return marks;
	}
	public void setMarks(Mark marks) {
		this.marks = marks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", marks="
				+ marks + "]";
	}

	
	
	
	
}
