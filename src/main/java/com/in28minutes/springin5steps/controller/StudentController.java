package com.in28minutes.springin5steps.controller;

import com.in28minutes.springin5steps.entity.Student;
import com.in28minutes.springin5steps.exception.StudentNotFoundException;
import com.in28minutes.springin5steps.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //------------------------GET METHODS -------//
    @GetMapping("/students")
    public ResponseEntity<?> getStudents() {
        List<Student> studentList = studentService.queryForStudents();
        if(studentList != null) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(200))
                    .cacheControl(CacheControl.maxAge(Duration.ofMinutes(50)))
                    .body(studentList);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Integer id) {
        Optional<Student> student = studentService.queryForStudentsById(id);

        if(student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            throw new StudentNotFoundException("Student id not found - " + id);
        }
    }


    //---------------------POST METHODS-----------//
    @PostMapping("/students")
    public int createStudent(@RequestBody Student student) {
            return studentService.createStudent(student);
    }

    @PostMapping("/students/bulk")
    public void createMultiple(@RequestBody List<Student> studentList) {
        studentService.createMultipleStudents(studentList);
    }
    //-------------PUT METHODS------------------//
    @PutMapping("/students")
    public ResponseEntity<?> updateStudent(@RequestBody Student updatedData) {
        Optional<Student> student = studentService.queryForStudentsById(updatedData.getId());
        if(student.isPresent()) {
            studentService.updateStudent(updatedData);
            return ResponseEntity.ok("Data updated Successfully");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    //--------------DELETE METHODS-------------//

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Deleted");
    }

    @DeleteMapping("/students")
    public ResponseEntity<?> deleteAll(){
        studentService.deleteAllStudents();
        return ResponseEntity.ok().build();
    }
}
