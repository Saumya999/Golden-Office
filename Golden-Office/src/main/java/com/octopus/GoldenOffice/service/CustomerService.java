package com.octopus.GoldenOffice.service;

import com.octopus.GoldenOffice.models.Customer;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findByEmail(String email);

    void saveOrUpdateCustomer(Customer customer);

    void deleteAccount (String id);

    boolean matchLoginCredentials(Customer customer) ;
}
