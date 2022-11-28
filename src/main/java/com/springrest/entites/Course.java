package com.springrest.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course {
	
	@Id
	@Column(name="ID")
	long id;
	
	@Column(name="TITLE")
	String title;
	
	@Column(name="DESCRIPTION")
	String description;
	
	//@Id
	//private long id;
	//private String title;
	//private String description;
	//generate constructor using fields
	public Course(long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	//generate super constructor
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//generate getters and setters methods
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	//generate toStringmethod
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
	

}
