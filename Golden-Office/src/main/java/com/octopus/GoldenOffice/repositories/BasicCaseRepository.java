package com.octopus.GoldenOffice.repositories;

import com.octopus.GoldenOffice.models.BasicCase;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BasicCaseRepository extends MongoRepository<BasicCase, String> {

    List<BasicCase> findAll();

    BasicCase findByEmail(String custEmail);

   //BasicCase findById(String caseId);
}
