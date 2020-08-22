package com.octopus.GoldenOffice.service.implementation;

import com.octopus.GoldenOffice.businessLogic.interfaces.MapEmployeeToR1Employee;
import com.octopus.GoldenOffice.models.Employee;
import com.octopus.GoldenOffice.repositories.EmployeeRepository;
import com.octopus.GoldenOffice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MapEmployeeToR1Employee mapEmployeeToR1Employee;

    @Override
    public void createEmployee(Employee employee) {
        String empID = mapEmployeeToR1Employee.generateRoleBasedEmployeeId(employee);
        if (empID != null) {
            employee.setId(empID);
        }
        employeeRepository.save(employee);
    }
}
