package com.octopus.GoldenOffice.service.implementation;

import com.octopus.GoldenOffice.models.Customer;
import com.octopus.GoldenOffice.repositories.CustomerRepository;
import com.octopus.GoldenOffice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public void saveOrUpdateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteAccount(String id) {
        customerRepository.deleteById(id);
    }

}
