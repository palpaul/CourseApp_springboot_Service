package com.springrest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entites.Course;
import com.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseservice;
	
	//need to create method
	@GetMapping("/home")
	public String home() {
		return "This is home page...";
	}
	
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		 return this.courseservice.getCourses();		
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseservice.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/addCourse")
	public Course addCourse(@RequestBody Course course) {
		return this.courseservice.addCourse(course);
		
	}
	
	@PutMapping("/updateCourse")
	public Course updateCourse(@RequestBody Course courseId) {
		return this.courseservice.updateCourse(courseId);
	}
	
	@DeleteMapping("/deleteCourse/{courseId}")
	public  ResponseEntity<String> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseservice.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK).ok("msg deleted");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR).ok("incorrect Id");
		}
		//return this.courseservice.deleteCourse(courseId);	
	}
	// all db methods
	//@CrossOrigin(origins = "http://localhost:8080")
	@CrossOrigin(origins="*",allowedHeaders="*")
	@GetMapping("/coursesDb")
	public List<Course> getCoursesdb(){
		 return this.courseservice.getCoursesdb();		
	}
	@CrossOrigin(origins="*",allowedHeaders="*")
	@GetMapping("/coursesDb/{courseId}")
	public Course getCoursedb(@PathVariable String courseId) {
		return this.courseservice.getCoursedb(Long.parseLong(courseId));
	}
	@CrossOrigin(origins="*",allowedHeaders="*")
	@PostMapping("/addCourseDb")
	public Course addCoursedb(@RequestBody Course course) {
		return this.courseservice.addCoursedb(course);
		
	}
	@CrossOrigin
	//@CrossOrigin(origins="*",allowedHeaders="*")
	@PutMapping("/updateCourseDb/")
	public Course updateCoursedb(@RequestBody Course course) {
		return this.courseservice.updateCoursedb(course);
	}
	
	@CrossOrigin(origins="*",allowedHeaders="*")
	@DeleteMapping("/deleteCourseDb/{courseId}")
	public  ResponseEntity<String> deleteCoursedb(@PathVariable String courseId) {
		try {
			this.courseservice.deleteCoursedb(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK).ok("msg deleted");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR).ok("incorrect Id");
		}
		//return this.courseservice.deleteCourse(courseId);	
	}

}
