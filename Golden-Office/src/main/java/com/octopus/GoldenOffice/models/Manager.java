package com.octopus.GoldenOffice.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "manager")
public class Manager extends Employee {


    /** Variables for Manager class */

    private List<String> workGroupIds;
    private List<String> developerIds;


}
