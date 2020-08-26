package com.octopus.GoldenOffice.service.implementation;

import com.octopus.GoldenOffice.businessLogic.interfaces.UtilityLogicInterface;
import com.octopus.GoldenOffice.models.Manager;
import com.octopus.GoldenOffice.models.WorkGroup;
import com.octopus.GoldenOffice.repositories.DeveloperRepository;
import com.octopus.GoldenOffice.repositories.ManagerRepository;
import com.octopus.GoldenOffice.repositories.WorkGroupRepository;
import com.octopus.GoldenOffice.service.IWorkGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkGroupService implements IWorkGroupService {

    @Autowired
    private WorkGroupRepository workGroupRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private UtilityLogicInterface utilityLogicInterface;


    @Override
    public void createWorkGroup(WorkGroup workGroup){
        Optional<Manager> manager = managerRepository.findById(workGroup.getManagerId());
        String teamID = utilityLogicInterface.IdGenerator();
        teamID = "Team"+"_"+teamID;
        List<String> workgroupIds = manager.get().getWorkGroupIds();
        workgroupIds.add(teamID);
        workGroup.setId(teamID);
        manager.get().setWorkGroupIds(workgroupIds);
        managerRepository.save(manager.get());
        workGroupRepository.save(workGroup);
    }
}
