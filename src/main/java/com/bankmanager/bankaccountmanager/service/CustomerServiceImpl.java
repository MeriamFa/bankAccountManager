package com.bankmanager.bankaccountmanager.service;

import com.bankmanager.bankaccountmanager.modele.Customer;
import com.bankmanager.bankaccountmanager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer retreiveCustomerById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public List<Customer> retrieveALLCustomer() {
        return customerRepository.findAll();
    }
}
