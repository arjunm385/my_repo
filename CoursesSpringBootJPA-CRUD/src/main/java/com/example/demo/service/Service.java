package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Courses;

public interface Service {

	public List<Courses> getAllCourses();
	public Optional<Courses> getCourse(int cid);
	public Courses createCourse(Courses courses);
	public Courses updateCourse(Courses courses);
	public String removeCourse(int cid);
}
