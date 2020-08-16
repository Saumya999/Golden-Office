package com.octopus.GoldenOffice.businessLogic.implementations;

import com.octopus.GoldenOffice.businessLogic.interfaces.UtilityLogicInterface;

import com.octopus.GoldenOffice.models.Customer;
import com.octopus.GoldenOffice.repositories.BasicCaseRepository;
import com.octopus.GoldenOffice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

@Service
public class UtilityLogic implements UtilityLogicInterface {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BasicCaseRepository basicCaseRepository;

    /** Id Generator for Customer
     * Catches the Current time and Split and join into a String to make Customised Id
     * for Every customer
     */

    public String IdGenerator() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);
        System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);

        String splitter[] = strDate.split("-");
        String dater = String.join("", splitter);
        String spliter[] = dater.split(":");
        dater = String.join("", spliter);
        spliter = dater.split(" ");
        dater = String.join("", spliter);
        System.out.println(dater.trim());

        return dater;
    }

    /** Update Customer Case List */

    public void updateCustomerCaseList(String custEmail, String caseId) {
        Customer customer = customerRepository.findByEmail(custEmail);
        List<String> caseListIds = customer.getCaseList();
        caseListIds.add(caseId);
        customer.setCaseList(caseListIds);
        customerRepository.save(customer);
    }
}
