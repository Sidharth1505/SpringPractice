package com.in28minutes.springin5steps;

import com.in28minutes.springin5steps.dao.AppDAO;
import com.in28minutes.springin5steps.entity.*;
import com.in28minutes.springin5steps.entity.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringIn5StepsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIn5StepsApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstrutor(appDAO);
//			createInstructorwithCourses(appDAO);
//			findInstructorById(appDAO);
//			findCoursesforInstructor(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
//			deleteCourse(appDAO);
//			createCourseandReviews(appDAO);
//			findCourseAndReviews(appDAO);
//			createCourseandStudents(appDAO);
//			findCourseAndStudentByCourseId(appDAO);
//			findCourseAndStudentByStudentId(appDAO);
//			addMoreCoursesForStudents(appDAO);
//			addMoreStudentsForCourses(appDAO);
			deleteStudent(appDAO);

		};



	}

	private void deleteStudent(AppDAO appDAO) {
		int id  = 1;
		appDAO.deleteStudent(id);
	}

	private void addMoreStudentsForCourses(AppDAO appDAO) {
		int id = 12;
		Course course = appDAO.findCourseAndStudentByCourseId(id);
		Student student = appDAO.findCourseAndStudentByStudentId(2);
		course.addStudent(student);
		appDAO.update(course);
	}

	private void addMoreCoursesForStudents(AppDAO appDAO) {
		int id = 1;
		Student student = appDAO.findCourseAndStudentByStudentId(id);
		Course course1 = new Course("How to solve Rubiks Cube");
		Course course2 = new Course("How to play San Andreas");
		student.addCourse(course1);
		student.addCourse(course2);
		appDAO.update(student);
	}

	private void findCourseAndStudentByStudentId(AppDAO appDAO) {
		int id = 1;
		Student student = appDAO.findCourseAndStudentByStudentId(id);
		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void findCourseAndStudentByCourseId(AppDAO appDAO) {
		int id = 12;
		Course course = appDAO.findCourseAndStudentByCourseId(id);
		System.out.println(course);
		System.out.println(course.getStudents());
	}

	private void createCourseandStudents(AppDAO appDAO) {
		Course course = new Course("How to become rich in 1 day");
		Student student1 = new Student("Sidharth", "Jain", "sidh@gmail.com");
		Student student2 = new Student("Hello", "Word", "hello@gmil.com");
		course.addStudent(student1);
		course.addStudent(student2);

		System.out.println(course);
		System.out.println(course.getStudents());
		appDAO.save(course);
	}

	private void findCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseandReviewById(id);
		System.out.println(course);
		System.out.println(course.getReviewList());
	}

	private void createCourseandReviews(AppDAO appDAO) {
		//create course
		Course course = new Course("Pacman-  How to score the 1M");
		// add reviwews
		course.add(new Review("Good Course"));
		course.add(new Review("Great Course"));
		course.add(new Review("Bad Course"));
		// sace the course
		System.out.println(course.getReviewList());
		appDAO.save(course);
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;
		appDAO.deleteCourseById(id);
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseById(id);
		course.setTitle("Spring Masterclass");
		appDAO.update(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		instructor.setFirstName("Rohit");
		appDAO.update(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void findCoursesforInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Find the instructor with Id : " + theId);
		Instructor tempInstructor  = appDAO.findInstructorById(theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("the associated courses "+ tempInstructor.getCourses());
	}

	private void findInstructorById(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Find the instructor with Id : " + theId);
		Instructor tempInstructor  = appDAO.findInstructorById(theId);
		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getCourses());
	}

	private void createInstructorwithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor(
				"Sidharth", "Jain", "sidharth@gmail.com"
		);
		InstructorDetail instructorDetail = new InstructorDetail(
				"https://www.luv2code.com/youtube", "Coding"
		);
		instructor.setInstructor_detail(instructorDetail);
//		Course course1 = new Course("Spring Boot Framework - MasterClass");
//		Course course2 = new Course("AWS Masterclass");
//		instructor.add(course1);
//		instructor.add(course2);

		List<Course> courses = Arrays.asList(
				new Course("Spring Boot - MasterClass"),
				new Course("AWS Learner Journey")
		);
		courses.forEach(course -> {
			course.setInstructor(instructor);
		});

		instructor.setCourses(courses);
		appDAO.save(instructor);
		System.out.println(instructor.getCourses());

	}

	private void deleteInstrutor(AppDAO appDAO) {
		int id= 1;
		appDAO.deleteinstructorbyId(id);

	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println(instructor);
	}

	private void createInstructor(AppDAO appDAO) {
		//create the instructor
		Instructor instructor = new Instructor(
				"Sidharth", "Jain", "sidharth@gmail.com"
		);
		InstructorDetail instructorDetail = new InstructorDetail(
				"https://www.luv2code.com/youtube", "Coding"
		);
		instructor.setInstructor_detail(instructorDetail);
		System.out.println("saving the instructor " + instructor);
		appDAO.save(instructor);

	}
}
