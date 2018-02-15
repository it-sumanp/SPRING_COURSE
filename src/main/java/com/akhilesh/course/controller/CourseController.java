package com.akhilesh.course.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akhilesh.course.model.Course;
import com.akhilesh.course.service.CourseService;


@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    private @ResponseBody Collection<Course> getCources() {

        return (Collection<Course>) courseService.getCources();

    }

    @RequestMapping(method = RequestMethod.GET, path = "/{courseId}")
    private @ResponseBody Course getCourceById(@PathVariable Integer courseId) {

        return courseService.getCourceById(courseId);

    }

}
