package com.bankmanager.bankaccountmanager.controller;

import com.bankmanager.bankaccountmanager.modele.BankAccount;
import com.bankmanager.bankaccountmanager.modele.Customer;
import com.bankmanager.bankaccountmanager.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/bankAccount/{bankAccountId}")
    public BankAccount getBankAccount(@PathVariable(name = "bankAccountId") Long bankAccountId) {
        return bankAccountService.retrieveBankAccount(bankAccountId).get();
    }


    @GetMapping("/bankAccount")
    public List<BankAccount> getBankAccount() {
        return bankAccountService.retrieveALLBankAccount();
    }


    @GetMapping("/customer")
    public List<Customer> getCustomer() {
        return bankAccountService.retrieveALLCustomer();
    }
}
