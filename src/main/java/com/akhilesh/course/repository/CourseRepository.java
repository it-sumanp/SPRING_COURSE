package com.akhilesh.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhilesh.course.model.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}