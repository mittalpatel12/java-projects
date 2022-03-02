package com.mittal.studentdemo.model;

import com.mittal.studentdemo.entity.Result;
import com.mittal.studentdemo.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StudentDto {
    private Student student;
    private List<ResultDto> results;
}
