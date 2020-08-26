package com.octopus.GoldenOffice.repositories;

import com.octopus.GoldenOffice.models.WorkGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkGroupRepository extends MongoRepository<WorkGroup, String> {
}
