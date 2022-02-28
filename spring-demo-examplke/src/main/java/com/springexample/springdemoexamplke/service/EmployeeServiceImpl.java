package com.springexample.springdemoexamplke.service;

import com.springexample.springdemoexamplke.data.models.Employee;
import com.springexample.springdemoexamplke.data.repository.EmployeeRepository;
import com.springexample.springdemoexamplke.data.payloads.request.EmployeeRequest;
import com.springexample.springdemoexamplke.data.payloads.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public MessageResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employeeRequest.getFirstName());
        newEmployee.setLastName(employeeRequest.getLastName());
        newEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
        newEmployee.setEmail(employeeRequest.getEmail());
        newEmployee.setDepartment(employeeRequest.getDepartment());
        newEmployee.setSalary(employeeRequest.getSalary());
        employeeRepository.save(newEmployee);
        return new MessageResponse("New Employee created successfully");
    }


    @Override
    public Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()){
            throw new RuntimeException("Employee not found: " + employeeId);
        }

        employeeOptional.get().setFirstName(employeeRequest.getFirstName());
        employeeOptional.get().setLastName(employeeRequest.getLastName());
        employeeOptional.get().setPhoneNumber(employeeRequest.getPhoneNumber());
        employeeOptional.get().setEmail(employeeRequest.getEmail());
        employeeOptional.get().setSalary(employeeRequest.getSalary());
        employeeOptional.get().setDepartment(employeeRequest.getDepartment());
        employeeRepository.save(employeeOptional.get());

        return employeeOptional;
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        if (employeeRepository.getById(employeeId).getId().equals(employeeId))
            employeeRepository.deleteById(employeeId);
        else
            throw new RuntimeException();
    }

    @Override
    public Employee getASingleEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
