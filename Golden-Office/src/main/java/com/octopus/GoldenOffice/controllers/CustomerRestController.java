package com.octopus.GoldenOffice.controllers;


import com.octopus.GoldenOffice.businessLogic.interfaces.UtilityLogicInterface;
import com.octopus.GoldenOffice.models.Customer;
import com.octopus.GoldenOffice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    private UtilityLogicInterface utilityLogic;

    @Autowired
    private CustomerService customerService;

    /** Find All the Customers  */

    @GetMapping(value = "/allCustomer")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    /** Find the Customers  by their Email Ids */

    @GetMapping(value = "/byEmail")
    public Customer getCustomerByEmail(@PathVariable("email") String email) {
        return customerService.findByEmail(email);
    }

    /** Create the Customers and Update the Customer credentials */

    @PostMapping(value="/create")
    public ResponseEntity<?> saveOrUpdateCustomer(@RequestBody Customer customer) {
        String CustId = "Customer" +"_"+ utilityLogic.IdGenerator();
        customer.setId(CustId);
        customerService.saveOrUpdateCustomer(customer);
        return new ResponseEntity("Customer created successfully", HttpStatus.OK);
    }

    /** Delete the customer by their Email Ids */

    @DeleteMapping(value = "/delete")
    public void deleteCustomer(@PathVariable String email) {
        customerService.deleteAccount(customerService.findByEmail(email).getEmail());
    }

}