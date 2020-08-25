package com.octopus.GoldenOffice.businessLogic.interfaces;

import com.octopus.GoldenOffice.models.Developer;
import com.octopus.GoldenOffice.models.Employee;
import com.octopus.GoldenOffice.models.Manager;

public interface MapEmployeeToR1Employee {

    String generateRoleBasedEmployeeId(Employee employee);

    Manager mapEmployeeToManager(Employee employee);

    Developer mapEmployeeToDeveloper(Employee employee);
}
