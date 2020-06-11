package com.bankmanager.bankaccountmanager.service;

import com.bankmanager.bankaccountmanager.modele.BankAccount;
import com.bankmanager.bankaccountmanager.modele.Customer;
import com.bankmanager.bankaccountmanager.repository.BankAccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountServiceImplTest {

    private static final long BANK_ACCOUNT_ID = 103L;
    private static final String DESCIPTION = "deposit";
    private static final double DEPOSIT_AMOUNT_LIMIT = 0.01;

    @InjectMocks
    private BankAccountService bankAccountService = new BankAccountServiceImpl();

    @Mock
    private BankAccountRepository bankAccountRepository;

    @Mock
    private AccountTransactionService accountTransactionService;

    /**
     * US 1 As a bank, deposit money from a customer to his account, is allowed when superior to €0.01
     * US 3 As a bank, a customer can display its account balance
     */
    private BankAccount bankAccount;
    private Customer customer;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        customer = new Customer("test", "Data", Arrays.asList(bankAccount));
        customer.setCustomerId(1L);
        bankAccount = new BankAccount(new BigDecimal("1000"), null, customer);
        bankAccount.setBankAccountId(BANK_ACCOUNT_ID);
        when(bankAccountRepository.findById(BANK_ACCOUNT_ID)).thenReturn(Optional.ofNullable(bankAccount));
    }


    @Test
    public void givenDepositAmountAndBankAccountThenVerifyFindBankAccountByID() {
        bankAccountService.deposit(BANK_ACCOUNT_ID, DEPOSIT_AMOUNT_LIMIT, DESCIPTION);
        verify(bankAccountRepository).findById(BANK_ACCOUNT_ID);
    }

    @Test
    public void givenDepositAmountcorrectThenSaveBankAccount() {
        bankAccountService.deposit(BANK_ACCOUNT_ID, 200, DESCIPTION);
        verify(bankAccountRepository).save(bankAccount);
        assertEquals(new BigDecimal(1200), bankAccount.getAccountBalance());
    }

    @Test
    public void givenDepositAmountlessthanlimitThenDoNotSaveBankAccount() {
        bankAccountService.deposit(BANK_ACCOUNT_ID, DEPOSIT_AMOUNT_LIMIT, DESCIPTION);
        verify(bankAccountRepository, never()).save(bankAccount);
        verify(accountTransactionService, never()).saveAccountTransaction(any());
        assertEquals(new BigDecimal(1000), bankAccount.getAccountBalance());
    }

    @Test
    public void givenDepositAmountlessthanlimitThenrunAccountTransactionAndSaveBankAccount() {
        bankAccountService.deposit(BANK_ACCOUNT_ID, 200, DESCIPTION);
        verify(accountTransactionService).saveAccountTransaction(any());
        assertEquals(new BigDecimal(1200), bankAccount.getAccountBalance());
    }

    @Test
    public void givenbankAccountIdThenRetrieveBanAccount() {
        assertEquals(bankAccount, bankAccountService.retrieveBankAccount(BANK_ACCOUNT_ID));
    }

    @Test(expected = NoSuchElementException.class)
    public void givenbankAccountNullIdThenRetrieveBankAccountKo() {
        bankAccountService.retrieveBankAccount(104L);
    }
}