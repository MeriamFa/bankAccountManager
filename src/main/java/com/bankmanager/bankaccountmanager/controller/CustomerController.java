package com.bankmanager.bankaccountmanager.controller;

import com.bankmanager.bankaccountmanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customerBankAccountBalance")
    public String getBankAccountBalance(@RequestParam(name = "customerId") Long customerId, @RequestParam(name = "bankAccountId") Long bankAccountId) {
        return customerService.displayAccountBalanceforCustomer(customerId,bankAccountId).toString();
    }
}
