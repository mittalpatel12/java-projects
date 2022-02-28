package com.springexample.springdemoexamplke.service;

import com.springexample.springdemoexamplke.data.models.Employee;
import com.springexample.springdemoexamplke.data.payloads.request.EmployeeRequest;
import com.springexample.springdemoexamplke.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    MessageResponse createEmployee(EmployeeRequest employeeRequest);
    Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);
    void deleteEmployee(Integer employeeId);
    Employee getASingleEmployee(Integer employeeId);
    List<Employee> getAllEmployee();
}
