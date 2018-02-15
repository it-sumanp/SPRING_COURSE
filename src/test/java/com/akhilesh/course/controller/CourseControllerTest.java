package com.akhilesh.course.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.akhilesh.course.model.Course;
import com.akhilesh.course.service.CourseService;


@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CourseService service;

    @Test
    public void whenGetCourses_thenReturnJsonArray() throws Exception {

        Course ma = new Course();
        ma.setCourseId(21);
        ma.setCourseName("MA");
        ma.setCourseDesc("Master in arts");
        List<Course> courses = Arrays.asList(ma);

        Mockito.when(service.getCources()).thenReturn(courses);
        mvc.perform(get("/course/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].courseName", is(ma.getCourseName())));
    }
}