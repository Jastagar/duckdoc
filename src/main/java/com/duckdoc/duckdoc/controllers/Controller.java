package com.duckdoc.duckdoc.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duckdoc.duckdoc.Courses;

@RestController
public class Controller {
	
	Courses a = new Courses(1,"ABC","DEF");
	@RequestMapping("/courses")
	public List<Courses> returnCourses(){
		return Arrays.asList(a,a);
	}
}
