package com.in28minutes.springin5steps.exception.handlers;

import com.in28minutes.springin5steps.error.StudentErrorResponse;
import com.in28minutes.springin5steps.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        StudentErrorResponse studentErrorResponse = StudentErrorResponse
                .builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage()).timeStamp(System.currentTimeMillis())
                .build();

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);

    }

}
