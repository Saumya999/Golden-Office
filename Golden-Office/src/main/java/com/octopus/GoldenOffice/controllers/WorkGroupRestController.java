package com.octopus.GoldenOffice.controllers;


import com.octopus.GoldenOffice.models.WorkGroup;
import com.octopus.GoldenOffice.service.IWorkGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/workGroup")
public class WorkGroupRestController {

    @Autowired
    private IWorkGroupService workGroupService;

    @PostMapping(value = "/createTeam")
    public void createTeam(@RequestBody WorkGroup workGroup) {
        workGroupService.createWorkGroup(workGroup);
    }
}
