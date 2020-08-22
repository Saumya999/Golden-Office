package com.octopus.GoldenOffice.repositories;

import com.octopus.GoldenOffice.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {

}
