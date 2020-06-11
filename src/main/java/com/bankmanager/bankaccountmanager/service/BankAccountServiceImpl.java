package com.bankmanager.bankaccountmanager.service;

import com.bankmanager.bankaccountmanager.modele.BankAccount;
import com.bankmanager.bankaccountmanager.modele.Customer;
import com.bankmanager.bankaccountmanager.repository.BankAccountRepository;
import com.bankmanager.bankaccountmanager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<BankAccount> retrieveBankAccount(Long bankAccountID) {
        return bankAccountRepository.findById(bankAccountID);
    }

    @Override
    public List<BankAccount> retrieveALLBankAccount() {
        return bankAccountRepository.findAll();
    }

    @Override
    public List<Customer> retrieveALLCustomer() {
        return customerRepository.findAll();
    }
}
