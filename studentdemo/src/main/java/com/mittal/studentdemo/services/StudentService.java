package com.mittal.studentdemo.services;

import com.mittal.studentdemo.dao.StudentDao;
import com.mittal.studentdemo.entity.Student;
import com.mittal.studentdemo.model.ResultDto;
import com.mittal.studentdemo.model.StudentDto;
import com.mittal.studentdemo.model.StudentFilterRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ResultService resultService;

    public List<Student> getAllStudent() {
        return studentDao.findAll();
    }

    public StudentDto getStudent(Integer studentId) {
        // convert to student dto
        // return student dto

        Student student = studentDao.findById(studentId).get();
        StudentDto studentDto = new StudentDto();
        studentDto.setStudent(student);
        List<ResultDto> resultDtos = resultService.getStudentResult(studentId);
        studentDto.setResults(resultDtos);
        return studentDto;
    }

    public List<Student> getStudentByLastnameGrade(StudentFilterRequest criteria) {
        List<Student> filteredStudents = new ArrayList<>();
        List<Student> students = studentDao.findAll();

        if (CollectionUtils.isNotEmpty(students)) {
            for (Student student : students) {
                if (StringUtils.isNotEmpty(criteria.getLastName())) {
                    if (!StringUtils.equalsIgnoreCase(criteria.getLastName(), student.getLastName())) {
                        continue;
                    }
                }
                if (StringUtils.isNotEmpty(criteria.getFirstName())) {
                    if (!StringUtils.equalsIgnoreCase(criteria.getFirstName(), student.getFirstName())) {
                        continue;
                    }
                }
                filteredStudents.add(student);
            }

        }
        return filteredStudents;

    }
}
