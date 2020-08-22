package com.octopus.GoldenOffice.repositories;

import com.octopus.GoldenOffice.models.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ManagerRepository extends MongoRepository<Manager,String> {

    Optional<Manager> findById(String Id);
}
