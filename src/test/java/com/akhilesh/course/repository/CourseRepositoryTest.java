package com.akhilesh.course.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.akhilesh.course.model.Course;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void whenFindById_ReturnCourse() {

        Course course = courseRepository.findOne(22);
        assertThat(course.getCourseName()).isEqualTo("BA");
    }

    @Test
    public void whenFindAll_ReturnCourses() {

        List<Course> courses = courseRepository.findAll();
        assertThat(courses.size()).isEqualTo(3);
    }

}