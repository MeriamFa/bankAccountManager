package com.bankmanager.bankaccountmanager.controller;

import com.bankmanager.bankaccountmanager.service.BankAccountService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
class BankAccountControllerTest {
    @InjectMocks
    private BankAccountController bankAccountController;
    @Mock
    private BankAccountService bankAccountService;


}