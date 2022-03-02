package com.mittal.studentdemo.controller;

import com.mittal.studentdemo.entity.Student;
import com.mittal.studentdemo.model.StudentFilterRequest;
import com.mittal.studentdemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> students = studentService.getAllStudent();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Student>> getStudentByLastnameGrade(@RequestBody StudentFilterRequest studentFilterRequest) {
        List<Student> students = studentService.getStudentByLastnameGrade(studentFilterRequest);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
