package com.in28minutes.springin5steps;

import com.in28minutes.springin5steps.dao.StudentDAO;
import com.in28minutes.springin5steps.entity.Student;
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


//	@Bean
//	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
//		return runner -> {
////			createStudent(studentDAO);
////			createMultipleStudents(studentDAO);
////			readStudents(studentDAO);
////			queryForStudents(studentDAO);
////			queryForStudentsByLastName(studentDAO);
////			updateStudent(studentDAO);
////			deleteStudent(studentDAO);
////			deleteAllStudents(studentDAO);
//		};
//
//	}



}
