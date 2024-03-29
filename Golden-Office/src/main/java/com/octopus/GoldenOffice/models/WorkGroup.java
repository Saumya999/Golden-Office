package com.octopus.GoldenOffice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "workGroup")
public class WorkGroup {

    /** Variable Declarations */

    @Id
    private String id;
    private String groupName;
    private String groupDefinition;
    private String managerId;
    private List<String> ticketIds;

    /** Default Constructor */

    public WorkGroup() {
    }


    /** Parametrized Constructor */

    public WorkGroup(String id, String groupName, String groupDefinition,
                     String managerId, List<String> ticketIds) {
        this.id = id;
        this.groupName = groupName;
        this.groupDefinition = groupDefinition;
        this.managerId = managerId;
        this.ticketIds = ticketIds;
    }

    /** Getter Setter */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDefinition() {
        return groupDefinition;
    }

    public void setGroupDefinition(String groupDefinition) {
        this.groupDefinition = groupDefinition;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public List<String> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<String> ticketIds) {
        this.ticketIds = ticketIds;
    }
}
