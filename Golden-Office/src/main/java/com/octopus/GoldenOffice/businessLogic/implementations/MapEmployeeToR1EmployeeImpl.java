package com.octopus.GoldenOffice.businessLogic.implementations;

import com.octopus.GoldenOffice.businessLogic.interfaces.MapEmployeeToR1Employee;
import com.octopus.GoldenOffice.businessLogic.interfaces.UtilityLogicInterface;
import com.octopus.GoldenOffice.models.Developer;
import com.octopus.GoldenOffice.models.Employee;
import com.octopus.GoldenOffice.models.Manager;
import com.octopus.GoldenOffice.repositories.DeveloperRepository;
import com.octopus.GoldenOffice.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.MalformedObjectNameException;
import java.util.ArrayList;
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
            Manager manager = new Manager();
            String finalEmpId = "Manager"+"_"+EmpID;
            return finalEmpId;
        } else if(DEVELOPER_ROLE.equalsIgnoreCase(employee.getRole())) {
            String EmpID = utilityLogicInterface.IdGenerator();
            String finalEmpId = "Developer"+"_"+EmpID;
            return finalEmpId;
        }
        return null;
    }

    public Manager mapEmployeeToManager(Employee employee) {
        Manager manager = new Manager();
        manager.setId(employee.getId());
        manager.setEmail(employee.getEmail());
        manager.setFirstName(employee.getFirstName());
        manager.setLastName(employee.getLastName());
        manager.setRole(employee.getRole());

        List<String>workGroupIds = new ArrayList<>();
        List<String>developerIds = new ArrayList<>();

        manager.setWorkGroupIds(workGroupIds);
        manager.setDeveloperIds(developerIds);

        return manager;
    }

    public Developer mapEmployeeToDeveloper(Employee employee) {
        Developer developer = new Developer();

        developer.setId(employee.getId());
        developer.setEmail(employee.getEmail());
        developer.setFirstName(employee.getFirstName());
        developer.setLastName(employee.getLastName());
        developer.setRole(employee.getRole());

        String workGroupId = "";
        String managerId = "";
        developer.setManagerId(managerId);
        developer.setWorkGroupId(workGroupId);
        return developer;
    }
}
