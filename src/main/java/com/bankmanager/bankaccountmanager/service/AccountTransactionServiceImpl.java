package com.bankmanager.bankaccountmanager.service;

import com.bankmanager.bankaccountmanager.modele.AccountTransaction;
import com.bankmanager.bankaccountmanager.repository.AccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @Override
    public void saveAccountTransaction(AccountTransaction accountTransaction) {
        accountTransactionRepository.save(accountTransaction);
    }
}
