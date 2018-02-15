package com.akhilesh.course.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akhilesh.course.model.Student;
import com.akhilesh.course.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public @ResponseBody Student createStudents(@Valid @RequestBody Student student) {

        student = studentService.createStudent(student);
        return student = studentService.getStudentById(student.getStudentId());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public @ResponseBody Collection<Student> getStudents() {

        return (Collection<Student>) studentService.getStudents();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{studentId}")
    public @ResponseBody Student getStudentById(@PathVariable Integer studentId) {

        return studentService.getStudentById(studentId);
    }

}
