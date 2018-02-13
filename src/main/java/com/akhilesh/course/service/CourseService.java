package com.akhilesh.course.service;

import com.akhilesh.course.model.Course;


public interface CourseService {

    Iterable<Course> getCources();

    Course getCourceById(Integer courseId);

    boolean isCourseExist(Integer courseId);
}
