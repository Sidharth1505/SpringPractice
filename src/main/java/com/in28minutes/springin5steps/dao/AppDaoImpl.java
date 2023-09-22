package com.in28minutes.springin5steps.dao;

import com.in28minutes.springin5steps.entity.Course;
import com.in28minutes.springin5steps.entity.Instructor;
import com.in28minutes.springin5steps.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDAO{

    @Autowired
    private final EntityManager entityManager;

    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }
    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteinstructorbyId(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        List<Course> courses = instructor.getCourses();
        courses.forEach(course -> {
            course.setInstructor(null);
        });
        entityManager.remove(instructor);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        //create the query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data" , Course.class
        );
        query.setParameter("data", id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id = :data" , Instructor.class
        );
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseandReviewById(int id) {
        TypedQuery<Course> courseTypedQuery = entityManager.createQuery(
                "SELECT c from Course c " +
                        "JOIN FETCH c.reviewList " +
                        "where c.id = :data ", Course.class
        );
        courseTypedQuery.setParameter("data", id);
        return courseTypedQuery.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentByCourseId(int id) {
        TypedQuery<Course> courseTypedQuery = entityManager.createQuery(
                "select c from Course c " +
                        "JOIN FETCH c.students " +
                        "where c.id = :data", Course.class
        );
        courseTypedQuery.setParameter("data", id);
        return courseTypedQuery.getSingleResult();
    }

    @Override
    public Student findCourseAndStudentByStudentId(int id) {
        TypedQuery<Student> courseTypedQuery = entityManager.createQuery(
                "select s from Student s " +
                        "JOIN FETCH s.courses " +
                        "where s.id = :data", Student.class
        );
        courseTypedQuery.setParameter("data", id);
        return courseTypedQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
