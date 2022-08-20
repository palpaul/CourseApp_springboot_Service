package com.springrest.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.entites.Course;

public interface CourseDao extends JpaRepository<Course, Long>{

}
