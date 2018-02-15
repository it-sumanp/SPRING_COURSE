package com.akhilesh.course.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akhilesh.course.model.Student;
import com.akhilesh.course.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseService courseService;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Iterable<Student> getStudents() {

        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer studentId) {

        return studentRepository.findOne(studentId);
    }

    @Override
    @Transactional
    public Student createStudent(Student student) {

        validateCourse(student.getCourse().getCourseId());
        student = studentRepository.saveAndFlush(student);
        entityManager.refresh(student);

        return student;
    }

    private void validateCourse(int courseId) {

        if (!courseService.isCourseExist(courseId)) {
            throw new IllegalArgumentException("Invalid courseId");
        }

    }

}
