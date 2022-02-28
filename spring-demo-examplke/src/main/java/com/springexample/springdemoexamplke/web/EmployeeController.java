package com.springexample.springdemoexamplke.web;

import com.springexample.springdemoexamplke.data.models.Employee;
import com.springexample.springdemoexamplke.data.payloads.request.EmployeeRequest;
import com.springexample.springdemoexamplke.data.payloads.response.MessageResponse;
import com.springexample.springdemoexamplke.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee", method = RequestMethod.POST)
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        Employee employee = employeeService.getASingleEmployee(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addEmployee(@RequestBody EmployeeRequest employee) {
        MessageResponse newEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeRequest employee) {
        Optional<Employee> updatedEmployee = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(updatedEmployee.get(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
