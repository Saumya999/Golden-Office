package com.octopus.GoldenOffice.models;

import java.util.Date;

public class AssignCaseInput extends BasicCase {

    private String managerId;
    private String developerId;

    /**  Parameterized Constructor */

    public AssignCaseInput(String managerId, String developerId) {
        this.managerId = managerId;
        this.developerId = developerId;
    }

    public AssignCaseInput(String id, String caseType, String caseShortDescription, String caseLongDescription, String caseImportance, Date createdAt, String email, String status, String managerId, String developerId) {
        super(id, caseType, caseShortDescription, caseLongDescription, caseImportance, createdAt, email, status);
        this.managerId = managerId;
        this.developerId = developerId;
    }

    /** Default Constructor */

    public AssignCaseInput() {
    }

    /** Getters Setters */

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }
}
