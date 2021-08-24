package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Courses;
import com.example.demo.service.Service;

@RestController
public class UserController {
	
	@Autowired
	private Service service;
	
@GetMapping("/home")
public String home(){
	return "this is home";
}

@GetMapping("/courses")
public List<Courses> getAllCourses(){
	
	return this.service.getAllCourses();
}
@GetMapping("/course/{cid}")
public Courses getCourse(@PathVariable String cid){
	
	return this.service.getCourse(Integer.parseInt(cid));
}
@PostMapping("/courses")
public Courses createCourse(@RequestBody Courses courses){
	return this.service.createCourse(courses);
}
@PutMapping("/courses")
public Courses updateCourse(@RequestBody Courses courses){
	return this.service.updateCourse(courses);
}
@DeleteMapping("/course/{cid}")
public String removeCourse(@PathVariable String cid){
	
	return this.service.removeCourse(Integer.parseInt(cid));
}
}
