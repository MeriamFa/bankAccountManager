package com.bankmanager.bankaccountmanager.service;

import com.bankmanager.bankaccountmanager.modele.Customer;

import java.math.BigDecimal;
import java.util.List;


public interface CustomerService {
    Customer retreiveCustomerById(Long customerId);
    List<Customer> retrieveALLCustomer();
    BigDecimal displayAccountBalanceforCustomer(Long customerId, Long bankAccountId);
}
