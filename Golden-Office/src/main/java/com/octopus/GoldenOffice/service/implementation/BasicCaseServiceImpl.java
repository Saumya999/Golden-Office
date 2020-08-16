package com.octopus.GoldenOffice.service.implementation;

import com.octopus.GoldenOffice.businessLogic.interfaces.UtilityLogicInterface;
import com.octopus.GoldenOffice.models.BasicCase;
import com.octopus.GoldenOffice.repositories.BasicCaseRepository;
import com.octopus.GoldenOffice.service.BasicCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BasicCaseServiceImpl implements BasicCaseService {

    @Autowired
    private BasicCaseRepository basicCaseRepository;

    @Autowired
    private UtilityLogicInterface utilityLogicInterface;

    @Override
    public List<BasicCase> findAll() {
        return basicCaseRepository.findAll();
    }

    @Override
    public void createCase(BasicCase basicCase) {
        Date createdAt = new Date();
        basicCase.setCreatedAt(createdAt);
        basicCaseRepository.save(basicCase);
        utilityLogicInterface.updateCustomerCaseList(basicCase.getCustomerEmail(), basicCase.getId());
    }

    @Override
    public void deleteCase(String caseId){
        basicCaseRepository.deleteById(caseId);
    }

}
