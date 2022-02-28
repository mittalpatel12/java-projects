package com.springexample.springdemoexamplke.data.repository;

import com.springexample.springdemoexamplke.data.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
