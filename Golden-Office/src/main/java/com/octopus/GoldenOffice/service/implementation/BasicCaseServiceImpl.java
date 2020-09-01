package com.octopus.GoldenOffice.service.implementation;

import com.octopus.GoldenOffice.businessLogic.interfaces.UtilityLogicInterface;
import com.octopus.GoldenOffice.models.*;
import com.octopus.GoldenOffice.repositories.BasicCaseRepository;
import com.octopus.GoldenOffice.repositories.CustomerRepository;
import com.octopus.GoldenOffice.repositories.DeveloperRepository;
import com.octopus.GoldenOffice.repositories.TicketRepository;
import com.octopus.GoldenOffice.service.BasicCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BasicCaseServiceImpl implements BasicCaseService {

    @Autowired
    private BasicCaseRepository basicCaseRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private CustomerRepository customerRepository;

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

    @Override
    public Ticket assignCaseToDeveloper(AssignCaseInput assignCaseInput) {
        Ticket ticket = new Ticket();
        ticket.setId(assignCaseInput.getId());
        ticket.setDeveloperId(assignCaseInput.getDeveloperId());
        ticket.setManagerId(assignCaseInput.getManagerId());

        Optional<Developer> developer = developerRepository.findById(assignCaseInput.getDeveloperId());
        String workGroupId = developer.get().getWorkGroupId();
        ticket.setWorkGroupId(workGroupId);
        ticket.setStatus("Allocated");
        ticket.setCaseImportance(assignCaseInput.getCaseImportance());
        ticket.setCaseType(assignCaseInput.getCaseType());
        ticket.setCreatedAt(assignCaseInput.getCreatedAt());
        ticket.setCaseLongDescription(assignCaseInput.getCaseLongDescription());
        ticket.setCaseShortDescription(assignCaseInput.getCaseShortDescription());
        ticket.setCustomerEmail(assignCaseInput.getCustomerEmail());

        ticketRepository.save(ticket);

        Customer customer = customerRepository.findByEmail(assignCaseInput.getCustomerEmail());
        List<String> ticketList = customer.getTicketList();
        ticketList.add(ticket.getId());
        customer.setTicketList(ticketList);
        customerRepository.save(customer);

        return ticket;
    }

}
