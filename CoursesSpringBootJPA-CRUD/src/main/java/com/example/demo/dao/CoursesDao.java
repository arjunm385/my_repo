package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Courses;

public interface CoursesDao extends JpaRepository<Courses, Integer>{

}
