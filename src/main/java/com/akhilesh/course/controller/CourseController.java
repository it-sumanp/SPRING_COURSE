package com.akhilesh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akhilesh.course.model.Course;
import com.akhilesh.course.service.CourseService;


@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    private Iterable<Course> getCources() {

        return courseService.getCources();

    }

    @RequestMapping(method = RequestMethod.GET, path = "/{courseId}")
    private Course getCourceById(@PathVariable Integer courseId) {

        return courseService.getCourceById(courseId);

    }

}
