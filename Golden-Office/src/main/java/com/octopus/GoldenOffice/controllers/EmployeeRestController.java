package com.octopus.GoldenOffice.controllers;

import com.octopus.GoldenOffice.models.Developer;
import com.octopus.GoldenOffice.models.Employee;
import com.octopus.GoldenOffice.models.Manager;
import com.octopus.GoldenOffice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/getAllManagers")
    public List<Manager> getManagers(){
        return employeeService.getAllManagers();
    }

    @GetMapping(value = "/getAllDevelopers")
    public List<Developer> getDevelopers(){
        return employeeService.getAllDeveloper();
    }

    /** @Body -- Employee mandatory */

    @PostMapping(value = "/createEmployee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity("Employee created successfully", HttpStatus.OK);
    }

    /** @Body Developer is mandatory
     * @PathVariable managerID is mandatory
     */

    @PostMapping(value = "/assignManager/{managerId}")
    public void assignManagerToDeveloper(@RequestBody Developer developer,
                                         @PathVariable("managerId") String managerId) {
        employeeService.assignManager(developer, managerId);
    }

    /**
     * @PathVariable managerId is mandatory
     */
    @GetMapping(value = "/getMyDeveloper/{managerId}")
    public List<Optional<Developer>> getDeveloperByManager(@PathVariable("managerId") String managerId) {
        return employeeService.getDevelopersByManager(managerId);
    }
}
