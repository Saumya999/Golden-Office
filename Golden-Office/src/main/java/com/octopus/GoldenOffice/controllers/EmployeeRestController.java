package com.octopus.GoldenOffice.controllers;

import com.octopus.GoldenOffice.models.Employee;
import com.octopus.GoldenOffice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/createEmployee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity("Employee created successfully", HttpStatus.OK);
    }
}
