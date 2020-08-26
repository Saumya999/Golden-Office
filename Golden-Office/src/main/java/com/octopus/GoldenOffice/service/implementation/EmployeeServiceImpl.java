package com.octopus.GoldenOffice.service.implementation;

import com.octopus.GoldenOffice.businessLogic.interfaces.MapEmployeeToR1Employee;
import com.octopus.GoldenOffice.models.Developer;
import com.octopus.GoldenOffice.models.Employee;
import com.octopus.GoldenOffice.models.Manager;
import com.octopus.GoldenOffice.repositories.DeveloperRepository;
import com.octopus.GoldenOffice.repositories.EmployeeRepository;
import com.octopus.GoldenOffice.repositories.ManagerRepository;
import com.octopus.GoldenOffice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private MapEmployeeToR1Employee mapEmployeeToR1Employee;

    private String MANAGER_ROLE = "manager";
    private String DEVELOPER_ROLE = "developer";


    /** create employee functionality and mapping those employee according to the role
     */

    @Override
    public void createEmployee(Employee employee) {
        String empID = mapEmployeeToR1Employee.generateRoleBasedEmployeeId(employee);
        if (empID != null) {
            employee.setId(empID);
        }
        if (MANAGER_ROLE.equalsIgnoreCase(employee.getRole())) {
            Manager manager = mapEmployeeToR1Employee.mapEmployeeToManager(employee);
            managerRepository.save(manager);
        } else if (DEVELOPER_ROLE.equalsIgnoreCase(employee.getRole())) {
            Developer developer = mapEmployeeToR1Employee.mapEmployeeToDeveloper(employee);
            developerRepository.save(developer);
        }
        employeeRepository.save(employee);
    }

    /** Get all managers from the Database */

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    /** Get all developers from the Database */

    @Override
    public List<Developer> getAllDeveloper() {
        return developerRepository.findAll();
    }

    /** Assign a manager to a Developer */

    @Override
    public void assignManager(Developer developer, String managerId) {
        Optional<Developer> developer1 = developerRepository.findById(developer.getId());
        Optional<Manager> manager = managerRepository.findById(managerId);
        List<String> developerIds = manager.get().getDeveloperIds();
        developerIds.add(developer.getId());
        manager.get().setDeveloperIds(developerIds);
        developer1.get().setManagerId(managerId);
        managerRepository.save(manager.get());
        developerRepository.save(developer1.get());
    }

    /** Get all the Developers under a certain manager */


    @Override
    public List<Optional<Developer>> getDevelopersByManager(String managerId) {
        Optional<Manager> manager = managerRepository.findById(managerId);
        List<Optional<Developer>> developers = new ArrayList<>();
        List<String> developerIds = manager.get().getDeveloperIds();

        if(!developerIds.isEmpty()) {
            for(String singleId : developerIds) {
                Optional<Developer> developer = developerRepository.findById(singleId);
                developers.add(developer);
            }
        }
        return developers;
    }
}
