package com.springrest.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;

import com.springrest.entites.Course;
import com.springrest.service.dao.CourseDao;

@Service 
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao coursedao;
	
	
	
	List<Course> list;
	public CourseServiceImpl() {
		
		list =new ArrayList<>();
		list.add(new Course(145,"SPringBoot","Java SpringBoot applicaiton"));
		list.add(new Course(250,"JavaScript","Learn JavaScript"));
	}
	
	
	
	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		
		Course c =null;
		for(Course course:list) {
			if(course.getId() ==  courseId) {
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course courseId) {
		list.forEach(e->{
			if(e.getId()== courseId.getId()) {
			e.setTitle(courseId.getTitle());
			e.setDescription(courseId.getDescription());	
			}
		});
		return courseId;
	}

	@Override
	public void deleteCourse(long parseLong) throws Exception {
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	}
	
	
	//database all methods
	@Override
	public List<Course> getCoursesdb() {
		// TODO Auto-generated method stub
		return coursedao.findAll();
	}



	@SuppressWarnings("deprecation")
	@Override
	public Course getCoursedb(long courseId) {
		// TODO Auto-generated method stub
		//return coursedao.getOne(courseId); // its deprecated
		return coursedao.findById(courseId).get();
	}



	@Override
	public Course addCoursedb(Course course) {
		// TODO Auto-generated method stub
		coursedao.save(course);
		return course;
	}


	//i case of update it will again ue a save method for updation
	@Override
	public Course updateCoursedb(Course course) {
		// TODO Auto-generated method stub
		coursedao.save(course);
		return course;
	}



	@Override
	public void deleteCoursedb(long parseLong) throws Exception {
		// TODO Auto-generated method stub
		Course entity= coursedao.getOne(parseLong);
		coursedao.delete(entity);
		
	}
}
