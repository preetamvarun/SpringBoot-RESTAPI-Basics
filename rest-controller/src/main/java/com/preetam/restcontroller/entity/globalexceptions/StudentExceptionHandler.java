package com.preetam.restcontroller.entity.globalexceptions;


import com.preetam.restcontroller.entity.StudentErrorPojo;
import com.preetam.restcontroller.entity.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorPojo> handleException(StudentNotFoundException exc){

        int status = HttpStatus.NOT_FOUND.value();
        String message = exc.getMessage();
        long ts = System.currentTimeMillis();

        StudentErrorPojo error = new StudentErrorPojo(status, message, ts);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorPojo> handleGenericException(Exception exc){

        int status = HttpStatus.NOT_FOUND.value();
        String message = "Not a valid Input";
        long ts = System.currentTimeMillis();

        StudentErrorPojo error = new StudentErrorPojo(status, message, ts);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
