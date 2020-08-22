package com.octopus.GoldenOffice.businessLogic.implementations;

import com.octopus.GoldenOffice.businessLogic.interfaces.MapEmployeeToR1Employee;
import com.octopus.GoldenOffice.businessLogic.interfaces.UtilityLogicInterface;
import com.octopus.GoldenOffice.models.Employee;
import com.octopus.GoldenOffice.models.Manager;
import com.octopus.GoldenOffice.repositories.DeveloperRepository;
import com.octopus.GoldenOffice.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapEmployeeToR1EmployeeImpl implements MapEmployeeToR1Employee {

    @Autowired
    private UtilityLogicInterface utilityLogicInterface;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    private String MANAGER_ROLE = "manager";
    private String DEVELOPER_ROLE = "developer";


    public String generateRoleBasedEmployeeId(Employee employee) {
        if(MANAGER_ROLE.equalsIgnoreCase(employee.getRole())) {
            String EmpID = utilityLogicInterface.IdGenerator();
            String finalEmpId = "Manager"+"_"+EmpID;
            return finalEmpId;
        } else if(DEVELOPER_ROLE.equalsIgnoreCase(employee.getRole())) {
            String EmpID = utilityLogicInterface.IdGenerator();
            String finalEmpId = "Developer"+"_"+EmpID;
            return finalEmpId;
        }
        return null;
    }
}
