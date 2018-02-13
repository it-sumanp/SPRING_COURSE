package com.akhilesh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhilesh.course.model.Course;
import com.akhilesh.course.repository.CourseRepository;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Iterable<Course> getCources() {

        return courseRepository.findAll();
    }

    @Override
    public Course getCourceById(Integer courseId) {

        return courseRepository.findOne(courseId);
    }

    @Override
    public boolean isCourseExist(Integer courseId) {

        return courseRepository.exists(courseId);
    }

}
