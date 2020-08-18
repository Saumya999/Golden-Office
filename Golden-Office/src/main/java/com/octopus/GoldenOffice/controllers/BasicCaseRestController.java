package com.octopus.GoldenOffice.controllers;

import com.octopus.GoldenOffice.businessLogic.interfaces.UtilityLogicInterface;
import com.octopus.GoldenOffice.models.BasicCase;
import com.octopus.GoldenOffice.models.Customer;
import com.octopus.GoldenOffice.service.BasicCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/case")
public class BasicCaseRestController {

    @Autowired
    private BasicCaseService basicCaseService;

    @Autowired
    private UtilityLogicInterface utilityLogic;

    @GetMapping(value = "/allCases")
    public List<BasicCase> getAllCases() {
        return basicCaseService.findAll();
    }

    @DeleteMapping(value = "/delete")
    public void deleteCase(@PathVariable String caseId) {
        basicCaseService.deleteCase(caseId);
    }

    @PostMapping(value = "/createCase")
    public ResponseEntity<?> saveOrUpdateCase(@RequestBody BasicCase basicCase) {
        String caseId = "Case" +"_"+ utilityLogic.IdGenerator();
        basicCase.setId(caseId);
        basicCaseService.createCase(basicCase);
        return new ResponseEntity("Case has been created successfully", HttpStatus.OK);
    }
}
