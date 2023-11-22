package com.preetam.restcontroller.rest;

import com.preetam.restcontroller.entity.StudentErrorPojo;
import com.preetam.restcontroller.entity.StudentNotFoundException;
import com.preetam.restcontroller.entity.StudentPojo;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestService {

    private List<StudentPojo> sps;

    // Called only once after the bean is constructed
    @PostConstruct
    public void LoadData(){
        sps = new ArrayList<>();
        sps.add(new StudentPojo("preetam", "varun"));
        sps.add(new StudentPojo("sandeep", "varma"));
        sps.add(new StudentPojo("ramesh", "patel"));
    }

    @GetMapping("/students/{studentId}")
    public StudentPojo getStudent(@PathVariable int studentId)
            throws StudentNotFoundException {

        if(studentId < 0 || studentId >= sps.size()){
            throw new StudentNotFoundException("Student not found with Id : "+ studentId);
        }

        return sps.get(studentId);
    }

    @GetMapping("/students")
    public List<StudentPojo> getStudents(){
        return sps;
    }
}
