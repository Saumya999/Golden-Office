package com.octopus.GoldenOffice.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "manager")
public class Manager extends Employee {


    /** Variables for Manager class */

    private List<String> workGroupIds;
    private List<String> developerIds;

    /** parametrized Constructor */

    public Manager(List<String> workGroupIds, List<String> developerIds) {
        this.workGroupIds = workGroupIds;
        this.developerIds = developerIds;
    }

    public Manager(String id, String firstName,
                   String lastName, String email, String role,
                   List<String> workGroupIds, List<String> developerIds) {
        super(id, firstName, lastName, email, role);
        this.workGroupIds = workGroupIds;
        this.developerIds = developerIds;
    }

    /** Default Constructor */

    public Manager() {
    }


    /** Getter Setters */
    public List<String> getWorkGroupIds() {
        return workGroupIds;
    }

    public void setWorkGroupIds(List<String> workGroupIds) {
        this.workGroupIds = workGroupIds;
    }

    public List<String> getDeveloperIds() {
        return developerIds;
    }

    public void setDeveloperIds(List<String> developerIds) {
        this.developerIds = developerIds;
    }
}
