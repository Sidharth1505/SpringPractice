package com.in28minutes.springin5steps.service;

import com.in28minutes.springin5steps.dao.StudentDAO;
import com.in28minutes.springin5steps.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("Student")
public class StudentService {
    @Autowired
    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void createMultipleStudents(List<Student> multipleStudents) {
//        List<Student> multipleStudents = Arrays.asList(
//                new Student("John", "Doe", "john@hello.com"),
//                new Student("Jane", "Doe", "doe@gmail.com"),
//                new Student("Donald", "Duck", "donald@gmail.com")
//        );
        studentDAO.saveMultiple(multipleStudents);
        System.out.println("Students saved....");
    }

    public void deleteAllStudents() {
        System.out.println("Deleting all data");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted rows " + numRowsDeleted);
    }

    public void deleteStudent(Integer studentId) {
        studentDAO.delete(studentId);
        System.out.println("Deleted ....");
    }

    public void updateStudent(Student student) {
        //retrieve based on the id : primary key

//        int studentId = 1;
//        System.out.println("Getting the student with id "+ studentId);
        Student myStudent = studentDAO.findById(student.getId());
//
//        //change the firstName to 'Scooby'
//        System.out.println("Change the firstName");
//        myStudent.setFirstName("Scooby");
        myStudent.setFirstName(student.getFirstName());
        myStudent.setEmail(student.getEmail());
        myStudent.setLastName(student.getLastName());
        //update
        studentDAO.update(myStudent);
        //save
        System.out.println("Updated Student " + myStudent);
    }

    public void queryForStudentsByLastName(StudentDAO studentDAO) {
        //get a list of students;
        List<Student> result = studentDAO.findByLastName("Sejal");
        if(result.isEmpty()) {
            System.out.println("No Data with Given LastName");
        } else {
            result.forEach(System.out :: println);
        }
    }
    public Optional<Student> queryForStudentsById(Integer id) {
        //get a list of students;
        Student result = studentDAO.findById(id);
//        if(result.isEmpty()) {
//            System.out.println("No Data with Given LastName");
//        } else {
//            result.forEach(System.out :: println);
//        }
        return Optional.ofNullable(result);
    }

    public List<Student> queryForStudents() {
        // get a list of students
        List<Student> result =  studentDAO.findAll();
        return result;
        //display
//        result.forEach(System.out ::println);
    }

    public int createStudent(Student student) {
        //create
//        System.out.println("Creating new Object ......");
//        Student tempStudent = new Student("Paul","Helman","paul@gmail.com");
//        //save
//        System.out.println("Saving the student,....");
        studentDAO.save(student);
        //display
//        System.out.println("Saved Student Generated Id.... " + tempStudent.getId());

        return student.getId();
    }

    public void readStudents(StudentDAO studentDAO) {
        System.out.println("Creating new Object ......");
        Student tempStudent = new Student("Harry","Sejall","harry@gmail.com");
        //save
        System.out.println("Saving the student,....");
        studentDAO.save(tempStudent);
        //display
        System.out.println("Saved Student Generated Id.... " + tempStudent.getId());
        //get the id
        Integer id = tempStudent.getId();
        //retrieve the student
        Student student = studentDAO.findById(id);
        System.out.println("student " + student);
    }
}
