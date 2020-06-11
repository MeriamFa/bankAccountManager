package com.bankmanager.bankaccountmanager.service;

import com.bankmanager.bankaccountmanager.modele.BankAccount;
import com.bankmanager.bankaccountmanager.modele.Customer;

import java.util.List;
import java.util.Optional;

public interface BankAccountService {
    Optional<BankAccount> retrieveBankAccount(Long bankAccountID);

    List<BankAccount> retrieveALLBankAccount();

    List<Customer> retrieveALLCustomer();
}
