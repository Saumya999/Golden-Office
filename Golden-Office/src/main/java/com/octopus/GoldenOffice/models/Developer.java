package com.octopus.GoldenOffice.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "developer")
public class Developer extends Employee {

    /** variable declaration for Developer class */

    private String workGroupId;
    private String managerId;


    public Developer() {
    }

    /** Constructor for Developer Class */
    public Developer(String workGroupId, String managerId) {
        this.workGroupId = workGroupId;
        this.managerId = managerId;
    }

    public Developer(String id, String firstName, String lastName,
                     String email, String role, String workGroupId, String managerId) {
        super(id, firstName, lastName, email, role);
        this.workGroupId = workGroupId;
        this.managerId = managerId;
    }

    /** Getters Setters */

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
