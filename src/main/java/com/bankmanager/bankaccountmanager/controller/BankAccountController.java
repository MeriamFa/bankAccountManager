package com.bankmanager.bankaccountmanager.controller;

import com.bankmanager.bankaccountmanager.modele.BankAccount;
import com.bankmanager.bankaccountmanager.modele.Customer;
import com.bankmanager.bankaccountmanager.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/bankAccount/{bankAccountId}")
    public BankAccount getBankAccount(@PathVariable(name = "bankAccountId") Long bankAccountId) {
        return bankAccountService.retrieveBankAccount(bankAccountId);
    }

    @GetMapping("/bankAccountBalance/{bankAccountId}")
    public String getBankAccountBalance(@PathVariable(name = "bankAccountId") Long bankAccountId) {
        return bankAccountService.retrieveBankAccount(bankAccountId).getAccountBalance().toString();
    }

    @GetMapping("/bankAccount")
    public List<BankAccount> getBankAccount() {
        return bankAccountService.retrieveALLBankAccount();
    }


    @GetMapping("/customer")
    public List<Customer> getCustomer() {
        return bankAccountService.retrieveALLCustomer();
    }

    @PutMapping("/deposit/{bankAccountId}")
    public void deposit(@RequestParam(name = "bankAccountId") Long bankAccountId, @RequestParam(name = "depositAmount") double depositAmount, @RequestParam(name = "description") String desciption) {
        bankAccountService.deposit(bankAccountId, depositAmount, desciption);
    }

    @PutMapping("/withdraw/{bankAccountId}")
    public void withdraw(@RequestParam(name = "bankAccountId") Long bankAccountId, @RequestParam(name = "withdrawAmount") double withdrawAmount, @RequestParam(name = "description") String desciption) {
        bankAccountService.withdraw(bankAccountId, withdrawAmount, desciption);
    }
}
