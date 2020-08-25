package com.octopus.GoldenOffice.repositories;

import com.octopus.GoldenOffice.models.Developer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DeveloperRepository extends MongoRepository<Developer,String> {

    Optional<Developer> findById(String id);
}
