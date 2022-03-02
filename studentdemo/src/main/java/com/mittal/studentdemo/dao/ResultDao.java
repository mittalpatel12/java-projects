package com.mittal.studentdemo.dao;

import com.mittal.studentdemo.entity.Result;
import com.mittal.studentdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultDao extends JpaRepository<Result, Integer> {

    List<Result> findAllByStudent(Student student);
}
