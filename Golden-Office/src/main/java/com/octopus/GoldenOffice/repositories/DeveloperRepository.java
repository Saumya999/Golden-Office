package com.octopus.GoldenOffice.repositories;

import com.octopus.GoldenOffice.models.Developer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeveloperRepository extends MongoRepository<Developer,String> {
}
