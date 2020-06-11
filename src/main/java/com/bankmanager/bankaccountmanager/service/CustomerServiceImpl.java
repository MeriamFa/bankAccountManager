package com.bankmanager.bankaccountmanager.service;

import com.bankmanager.bankaccountmanager.modele.Customer;
import com.bankmanager.bankaccountmanager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
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

    @Override
    public BigDecimal displayAccountBalanceforCustomer(Long customerId, Long bankAccountId) {
        Customer customer =customerRepository.findById(customerId).get();

        return !CollectionUtils.isEmpty(customer.getBankAccountList())?customer.getBankAccountList().stream()
                .filter(bankAccount -> bankAccountId.equals(bankAccount.getBankAccountId()))
                .map(bankAccount -> bankAccount.getAccountBalance())
                .findFirst().get(): null;
    }
}
