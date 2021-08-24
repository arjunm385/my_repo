package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Courses;
import com.example.demo.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

	List<Courses> list;
	public ServiceImpl() {
		
		list=new ArrayList<>();
		Courses courses1=new Courses(141, "java", "this is java course");
		Courses courses2=new Courses(155, "python", "this is python big data");
		list.add(courses1);
		list.add(courses2);
	}
	
	@Override
	public List<Courses> getAllCourses() {
		return list;
	}

	@Override
	public Courses getCourse(int cid) {
		Courses c=null;
		for (Courses courses : list) {
			if(courses.getId()==cid)
			{
				c=courses;
				break;
			}
		}
		return c;
	}

	@Override
	public Courses createCourse(Courses courses) {
		list.add(courses);
		return courses;
	}

	@Override
	public Courses updateCourse(Courses courses) {
		for (Courses course : list) {
			if(course.getId()==courses.getId())
			{
				course.setTitle(courses.getTitle());
				course.setDescription(courses.getDescription());
				break;
			}
		}
		return courses;
	}

	@Override
	public String removeCourse(int cid) {
		List<Courses> list1=new ArrayList<>();
		for (Courses courses : list) {
			list1.add(courses);
		}
		list.clear();
		for (Courses courses : list1) {
			if(courses.getId()!=cid)
			{
				list.add(courses);
			}
		}
		return "course deleted sucessfully";
	}
	
	
	
	

}
