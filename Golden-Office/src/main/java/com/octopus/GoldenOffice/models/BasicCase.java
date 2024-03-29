package com.octopus.GoldenOffice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "case")
public class BasicCase {
    @Id
    public String id;
    public String caseType;
    public String caseShortDescription;
    public String caseLongDescription;
    public String caseImportance;
    public Date createdAt;
    public String email;
    public String status;



    /** Getter and Setter and Constructor for Model class */

    public BasicCase() {
    }

    public BasicCase(String id, String caseType,
                     String caseShortDescription, String caseLongDescription,
                     String caseImportance, Date createdAt, String email, String status) {
        this.id = id;
        this.caseType = caseType;
        this.caseShortDescription = caseShortDescription;
        this.caseLongDescription = caseLongDescription;
        this.caseImportance = caseImportance;
        this.createdAt = createdAt;
        this.email = email;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseShortDescription() {
        return caseShortDescription;
    }

    public void setCaseShortDescription(String caseShortDescription) {
        this.caseShortDescription = caseShortDescription;
    }

    public String getCaseLongDescription() {
        return caseLongDescription;
    }

    public void setCaseLongDescription(String caseLongDescription) {
        this.caseLongDescription = caseLongDescription;
    }

    public String getCaseImportance() {
        return caseImportance;
    }

    public void setCaseImportance(String caseImportance) {
        this.caseImportance = caseImportance;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCustomerEmail() {
        return email;
    }

    public void setCustomerEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
