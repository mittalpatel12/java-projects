package com.mittal.studentdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class StudentUpdateRequest {
    private int id;
    private String firstName;
    private String lastName;

}
