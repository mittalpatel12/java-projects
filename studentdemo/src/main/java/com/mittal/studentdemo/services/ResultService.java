package com.mittal.studentdemo.services;

import com.mittal.studentdemo.dao.ResultDao;
import com.mittal.studentdemo.entity.Result;
import com.mittal.studentdemo.entity.Student;
import com.mittal.studentdemo.model.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {
    @Autowired
    private ResultDao resultDao;

    public List<Result> getAllResults() {
        return resultDao.findAll();
    }

    public List<ResultDto> getStudentResult(Integer studentId) {
        List<ResultDto> resultDtos = new ArrayList<>();
        Student student = new Student();
        student.setId(studentId);
       // String lastName = student.getLastName();

       // if (lastName == "patel")
            List<Result> results = resultDao.findAllByStudent(student);

            for (Result result : results) {
                if (!result.getGrade().equals('B')) {
                    continue;
                }
                    ResultDto resultDto = new ResultDto();
                    resultDto.setId(result.getResultId());
                    resultDto.setGrade(result.getGrade());
                    resultDto.setMarks(result.getMarks());
                    resultDto.setTotalMarks(result.getTotalMarks());
                    resultDto.setPass(result.getMarks() >= 500);
                    resultDtos.add(resultDto);

            }

        return resultDtos;
    }
}
