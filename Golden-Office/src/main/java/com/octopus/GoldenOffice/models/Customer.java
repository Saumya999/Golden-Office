package com.octopus.GoldenOffice.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "customer")
public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> caseList;
    private List<String> ticketList;
    private String password;



    public Customer() {
    }

    public Customer(String id, String firstName, String lastName,
                    String email, List<String> caseList,
                    List<String> ticketList, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.caseList = caseList;
        this.ticketList = ticketList;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getCaseList() {
        return caseList;
    }

    public void setCaseList(List<String> caseList) {
        this.caseList = caseList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<String> ticketList) {
        this.ticketList = ticketList;
    }
}
