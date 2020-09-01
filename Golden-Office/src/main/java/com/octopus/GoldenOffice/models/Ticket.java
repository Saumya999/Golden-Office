package com.octopus.GoldenOffice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Tickets")
public class Ticket extends BasicCase{

    /** Variable declaration */
    @Id
    private String Id;
    private String developerId;
    private String workGroupId;
    private String managerId;

    /** Constructor */

    public Ticket() {
    }

    /** Parameterized constructor */

    public Ticket(String developerId, String workGroupId, String managerId) {
        this.developerId = developerId;
        this.workGroupId = workGroupId;
        this.managerId = managerId;
    }

    public Ticket(String id, String caseType, String caseShortDescription,
                  String caseLongDescription, String caseImportance, Date createdAt,
                  String email, String status, String developerId,
                  String workGroupId, String managerId) {
        super(id, caseType, caseShortDescription, caseLongDescription,
                caseImportance, createdAt, email, status);
        this.developerId = developerId;
        this.workGroupId = workGroupId;
        this.managerId = managerId;
    }

    /** Getters and Setters */

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getWorkGroupId() {
        return workGroupId;
    }

    public void setWorkGroupId(String workGroupId) {
        this.workGroupId = workGroupId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
}
