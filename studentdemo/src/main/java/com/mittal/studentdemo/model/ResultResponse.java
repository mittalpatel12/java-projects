package com.mittal.studentdemo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ResultResponse {
    private StudentDto studentDto;
    private List<ResultDto> resultDtos;
}
