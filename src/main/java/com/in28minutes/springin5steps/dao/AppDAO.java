package com.in28minutes.springin5steps.dao;

import com.in28minutes.springin5steps.entity.Course;
import com.in28minutes.springin5steps.entity.Instructor;
import com.in28minutes.springin5steps.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteinstructorbyId(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void update(Instructor instructor);

    void update(Course course);
    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);
    Course findCourseandReviewById(int id);
    Course findCourseAndStudentByCourseId(int id);
    Student findCourseAndStudentByStudentId(int id);
    void update(Student student);
    void deleteStudent(int id);
}
