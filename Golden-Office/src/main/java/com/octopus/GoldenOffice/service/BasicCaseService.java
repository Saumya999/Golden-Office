package com.octopus.GoldenOffice.service;

import com.octopus.GoldenOffice.models.AssignCaseInput;
import com.octopus.GoldenOffice.models.BasicCase;
import com.octopus.GoldenOffice.models.Ticket;

import java.util.List;

public interface BasicCaseService  {

    List<BasicCase> findAll();

    void createCase(BasicCase basicCase);

    void deleteCase(String caseIds);

    Ticket assignCaseToDeveloper(AssignCaseInput assignCaseInput);

}
