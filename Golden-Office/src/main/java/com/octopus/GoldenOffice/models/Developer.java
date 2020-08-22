package com.octopus.GoldenOffice.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "developer")
public class Developer extends Employee {

    /** variable declaration for Developer class */

    private String workGroupId;
    private String managerId;
}
