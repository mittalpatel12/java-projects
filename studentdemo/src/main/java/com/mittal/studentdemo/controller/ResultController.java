package com.mittal.studentdemo.controller;

import com.mittal.studentdemo.entity.Result;
import com.mittal.studentdemo.entity.Student;
import com.mittal.studentdemo.model.ResultDto;
import com.mittal.studentdemo.model.ResultResponse;
import com.mittal.studentdemo.model.StudentDto;
import com.mittal.studentdemo.services.ResultService;
import com.mittal.studentdemo.services.StudentService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(value = "/result")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @Autowired
    private StudentService studentService;

    @Setter
    ResultResponse resultResponse = new ResultResponse();

    @GetMapping(value = "/all")
    public ResponseEntity<List<Result>> getAllResults() {
        List<Result> results = resultService.getAllResults();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping("/{student-id}")
    public ResponseEntity<StudentDto> createResultStatus(@PathVariable("student-id") Integer studentId) {
        StudentDto studentDto = studentService.getStudent(studentId);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }
}
