package com.octopus.GoldenOffice.businessLogic.interfaces;

import com.octopus.GoldenOffice.models.Employee;

public interface MapEmployeeToR1Employee {

    String generateRoleBasedEmployeeId(Employee employee);
}
