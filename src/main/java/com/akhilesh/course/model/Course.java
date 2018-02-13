package com.akhilesh.course.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@Table(name = "COURSE")
@Entity
public class Course {

    @Id
    @Column(name = "COURSE_ID", nullable = false)
    private int courseId;
    @Column(name = "COURSE_NAME", nullable = false)
    private String courseName;
    @Column(name = "COURSE_DESC", nullable = false)
    private String courseDesc;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Set<Student> students;

    public int getCourseId() {

        return courseId;
    }

    public void setCourseId(int courseId) {

        this.courseId = courseId;
    }

    public String getCourseName() {

        return courseName;
    }

    public void setCourseName(String courseName) {

        this.courseName = courseName;
    }

    public String getCourseDesc() {

        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {

        this.courseDesc = courseDesc;
    }

    public Set<Student> getStudents() {

        return students;
    }

    public void setStudents(Set<Student> students) {

        this.students = students;
    }

    @Override
    public String toString() {

        return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDesc=" + courseDesc
            + ", students=" + students + "]";
    }

}
