package com.akhilesh.course.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.akhilesh.course.model.Course;
import com.akhilesh.course.repository.CourseRepository;


@RunWith(SpringRunner.class)
public class CourseServiceTest {

    @TestConfiguration
    static class CourseServiceImplTestContextConfiguration {

        @Bean
        public CourseService courseService() {

            return new CourseServiceImpl();
        }
    }

    @Autowired
    private CourseService courseService;

    @MockBean
    private CourseRepository courseRepository;

    @Before
    public void setUp() {

        Course ma = new Course();
        ma.setCourseId(21);
        ma.setCourseName("MA");
        ma.setCourseDesc("Master In Arts");

        Course ba = new Course();
        ba.setCourseId(21);
        ba.setCourseName("BA");
        ba.setCourseDesc("Bachlor In Arts");

        Mockito.when(courseRepository.findOne(ma.getCourseId())).thenReturn(ma);
        Mockito.when(courseRepository.findAll()).thenReturn(Arrays.asList(ma, ba));

    }

    @Test
    public void whenGetCourses_thenGetTwoCourse() {

        Iterable<Course> course = courseService.getCources();

        assertThat(((Collection<Course>) course).size()).isEqualTo(2);
    }

    @Test
    public void whenGetCourseById_thenGetCourse() {

        Course course = courseService.getCourceById(21);

        assertThat(course.getCourseName()).isEqualTo("MA");
    }

}
