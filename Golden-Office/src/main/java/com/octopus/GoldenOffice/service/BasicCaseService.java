package com.octopus.GoldenOffice.service;

import com.octopus.GoldenOffice.models.BasicCase;

import java.util.List;

public interface BasicCaseService  {

    List<BasicCase> findAll();

    void createCase(BasicCase basicCase);

    void deleteCase(String caseIds);

}
