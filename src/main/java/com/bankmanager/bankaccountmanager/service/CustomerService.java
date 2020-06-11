package com.bankmanager.bankaccountmanager.service;

import com.bankmanager.bankaccountmanager.modele.Customer;

import java.util.List;


public interface CustomerService {
    Customer retreiveCustomerById(Long customerId);
    List<Customer> retrieveALLCustomer();
}
