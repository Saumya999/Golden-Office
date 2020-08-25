package com.octopus.GoldenOffice.service;

import com.octopus.GoldenOffice.models.Developer;
import com.octopus.GoldenOffice.models.Employee;
import com.octopus.GoldenOffice.models.Manager;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void createEmployee(Employee employee);

    List<Manager> getAllManagers();

    List<Developer> getAllDeveloper();

    void assignManager(Developer developer, String managerId);

    List<Optional<Developer>> getDevelopersByManager(String managerId);
}
