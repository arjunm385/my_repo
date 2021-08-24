package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.CoursesDao;
import com.example.demo.model.Courses;
import com.example.demo.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

	@Autowired
	private CoursesDao cd;
	
	@Override
	public List<Courses> getAllCourses() {
		return cd.findAll();
	}

	@Override
	public Optional<Courses> getCourse(int cid) {
		return cd.findById(cid);
	}

	@Override
	public Courses createCourse(Courses courses) {
		cd.save(courses);
		return courses;
	}

	@Override
	public Courses updateCourse(Courses courses) {
		cd.save(courses);
		return courses;
	}

	@Override
	public String removeCourse(int cid) {
		cd.deleteById(cid);
		return "course deleted sucessfully";
	}
	
	
	
	

}
