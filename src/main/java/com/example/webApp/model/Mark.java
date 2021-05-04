package com.example.webApp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="marks")
public class Mark {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="m_id")
	private int m_id;
	
	@Column(name="english")
	private float english;
	
	@Column(name="maths")
	private float maths;
	
	@Column(name="marathi")
	private float marathi;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student students;


	
	public Mark() {
		
	}

	public Mark(int id, float english, float maths, float marathi, Student student) {
		super();
		this.m_id = id;
		this.english = english;
		this.maths = maths;
		this.marathi = marathi;
		this.students = student;
	}


	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public float getEnglish() {
		return english;
	}

	public void setEnglish(float english) {
		this.english = english;
	}

	public float getMaths() {
		return maths;
	}

	public void setMaths(float maths) {
		this.maths = maths;
	}

	public float getMarathi() {
		return marathi;
	}

	public void setMarathi(float marathi) {
		this.marathi = marathi;
	}

	public Student getStudent() {
		return students;
	}

	public void setStudent(Student student) {
		this.students = student;
	}
	
	

}
