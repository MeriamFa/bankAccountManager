package com.bankmanager.bankaccountmanager.service;

import com.bankmanager.bankaccountmanager.modele.AccountTransaction;
import com.bankmanager.bankaccountmanager.modele.BankAccount;
import com.bankmanager.bankaccountmanager.modele.Customer;
import com.bankmanager.bankaccountmanager.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private static final double LIMIT_DEPOSIT = 0.01;
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountTransactionService accountTransactionService;

    @Override
    public BankAccount retrieveBankAccount(Long bankAccountID) {
        return bankAccountRepository.findById(bankAccountID).get();
    }

    @Override
    public List<BankAccount> retrieveALLBankAccount() {
        return bankAccountRepository.findAll();
    }

    @Override
    public List<Customer> retrieveALLCustomer() {
        return customerService.retrieveALLCustomer();
    }

    @Override
    public void deposit(Long bankAccountId, double depositAmount, String desciption) {
        BankAccount bankAccount = bankAccountRepository.findById(bankAccountId).get();
        if (depositAmount > LIMIT_DEPOSIT) {
            bankAccount.setAccountBalance(bankAccount.getAccountBalance().add(new BigDecimal(depositAmount)));
            bankAccountRepository.save(bankAccount);
            AccountTransaction accountTransaction = new AccountTransaction(new Date(), desciption, depositAmount, bankAccount);
            accountTransactionService.saveAccountTransaction(accountTransaction);
        }
    }


}
