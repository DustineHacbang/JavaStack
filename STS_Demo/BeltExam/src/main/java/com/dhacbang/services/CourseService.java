package com.dhacbang.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhacbang.models.Course;
import com.dhacbang.repos.CourseRepo;

@Service
public class CourseService {
	@Autowired
	private CourseRepo courseRepo;
	

	
	//____________Create____________
	public Course save(Course c) {
		return courseRepo.save(c);
	}
	//_____________Read_____________
	public List<Course> getAll(){
		return courseRepo.findAll();
	}
	
	public Course getOne(Long id) {
		Optional<Course> optionalCourse = courseRepo.findById(id);
		
		if(optionalCourse.isPresent()) {
			return optionalCourse.get();
		}else {
			return null;
		}
	}
	//____________Delete____________
	
	public void delete(Long id) {
		courseRepo.deleteById(id);
	}
	
	//________Relationships_________
}
