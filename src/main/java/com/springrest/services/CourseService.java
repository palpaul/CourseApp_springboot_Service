package com.springrest.services;

import java.util.List;
import com.springrest.entites.Course;

public interface CourseService {

	public List<Course> getCourses();
	
	public Course getCourse(long courseId );
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(long parseLong) throws Exception;
	
	
	//with database
	
public List<Course> getCoursesdb();
	
	public Course getCoursedb(long courseId );
	
	public Course addCoursedb(Course course);
	
	public Course updateCoursedb(Course courseId);
	
	public void deleteCoursedb(long parseLong) throws Exception;
	
	
}
