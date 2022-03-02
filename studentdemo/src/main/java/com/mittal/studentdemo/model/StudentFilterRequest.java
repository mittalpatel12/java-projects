package com.mittal.studentdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentFilterRequest {
    private String lastName;

    @JsonProperty("first-name")
    private String firstName;
}
