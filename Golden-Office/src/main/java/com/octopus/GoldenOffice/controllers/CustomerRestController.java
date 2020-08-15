package com.octopus.GoldenOffice.controllers;


import com.octopus.GoldenOffice.models.Customer;
import com.octopus.GoldenOffice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
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
    private CustomerService customerService;

    /** Find All the Customers  */

    @GetMapping(value = "/")
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
    public ResponseEntity<?> savOorUpdateCustomer(@RequestBody Customer customer) {
        String CustId = "Customer"+"_"+IdGenerator();
        customer.setCustId(CustId);
        customerService.saveOrUpdateCustomer(customer);
        return new ResponseEntity("Customer created successfully", HttpStatus.OK);
    }

    /** Delete the customer by their Email Ids */

    @DeleteMapping(value = "/delete")
    public void deleteCustomer(@PathVariable String email) {
        customerService.deleteAccount(customerService.findByEmail(email).getEmail());
    }


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
}