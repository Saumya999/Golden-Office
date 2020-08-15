package com.octopus.GoldenOffice.repositories;

import com.octopus.GoldenOffice.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByEmail(String email);

}
