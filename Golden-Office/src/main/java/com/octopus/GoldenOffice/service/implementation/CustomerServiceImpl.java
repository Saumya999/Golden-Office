package com.octopus.GoldenOffice.service.implementation;

import com.octopus.GoldenOffice.models.Customer;
import com.octopus.GoldenOffice.repositories.CustomerRepository;
import com.octopus.GoldenOffice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
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
        SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
        String base64Hash = sCryptPasswordEncoder.encode(customer.getPassword());
        customer.setPassword(base64Hash);
        customerRepository.save(customer);
    }

    @Override
    public void deleteAccount(String id) {
        customerRepository.deleteById(id);
    }

    /** this function needs to developed for the sake of login
     * credentials matching purpose
     * @param customer
     * @return boolean
     */

    @Override
    public boolean matchLoginCredentials(Customer customer) {
        Customer dbCustomer = customerRepository.findByEmail(customer.getEmail());
        String dbCustomerPassword = dbCustomer.getPassword();
        SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
        String loginCustomerPassword = sCryptPasswordEncoder.encode(customer.getPassword());

        if (dbCustomerPassword == loginCustomerPassword) {
            return true;
        }
        return false;
    }
}
