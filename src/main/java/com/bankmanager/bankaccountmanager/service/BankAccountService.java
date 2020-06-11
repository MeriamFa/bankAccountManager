package com.bankmanager.bankaccountmanager.service;

import com.bankmanager.bankaccountmanager.modele.BankAccount;
import com.bankmanager.bankaccountmanager.modele.Customer;

import java.util.List;

public interface BankAccountService {
    BankAccount retrieveBankAccount(Long bankAccountID);

    List<BankAccount> retrieveALLBankAccount();

    List<Customer> retrieveALLCustomer();

    void deposit(Long bankAccountId, double depositAmount,String  desciption);

    void withdraw(Long bankAccountId, double withdrawAmount,String  desciption);
}
