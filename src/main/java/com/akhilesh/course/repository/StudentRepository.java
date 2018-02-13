package com.akhilesh.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhilesh.course.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
