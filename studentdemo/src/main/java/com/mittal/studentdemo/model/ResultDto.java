package com.mittal.studentdemo.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultDto {

    private int id;
    private int marks;
    private int totalMarks;
    private String grade;
    private boolean pass;
}
