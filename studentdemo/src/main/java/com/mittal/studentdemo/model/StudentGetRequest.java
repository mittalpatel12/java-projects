package com.mittal.studentdemo.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentGetRequest {
    private int id;
    private String first_name;
    private String last_name;
}
