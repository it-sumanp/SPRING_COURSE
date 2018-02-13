package com.akhilesh.course.service;

import com.akhilesh.course.model.Student;


public interface StudentService {

    public Student createStudent(Student student);

    public Iterable<Student> getStudents();

    public Student getStudentById(Integer studentId);

}
