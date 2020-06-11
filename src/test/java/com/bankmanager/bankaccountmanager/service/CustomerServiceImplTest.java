package com.bankmanager.bankaccountmanager.service;

import com.bankmanager.bankaccountmanager.modele.BankAccount;
import com.bankmanager.bankaccountmanager.modele.Customer;
import com.bankmanager.bankaccountmanager.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    private static final long CUSTOMER_ID = 1L;
    private static final long BANK_ACCOUNT_ID = 103L;
    @InjectMocks
    private CustomerService customerService = new CustomerServiceImpl();

    @Mock
    private CustomerRepository customerRepository;

    private Customer customer;
    private BankAccount bankAccount;

    @Before
    public void initMocks() {
        customer = new Customer("test", "Data", null);
        customer.setCustomerId(CUSTOMER_ID);
        bankAccount = new BankAccount(new BigDecimal("1000"), null, customer);
        bankAccount.setBankAccountId(BANK_ACCOUNT_ID);
        customer.setBankAccountList(Arrays.asList(bankAccount));
        when(customerRepository.findById(CUSTOMER_ID)).thenReturn(Optional.ofNullable(customer));
    }

    @Test
    public void givenCustomerIdwithNoBankAccountexistThanDisplayaccountBalanceNull() {
        //Given
        customer.setBankAccountList(null);
        when(customerRepository.findById(CUSTOMER_ID)).thenReturn(Optional.ofNullable(customer));

        //When //Then
        assertNull(customerService.displayAccountBalanceforCustomer(CUSTOMER_ID, BANK_ACCOUNT_ID));
    }

    @Test
    public void givenCustomerIdAndbankAccountexistThanDisplayaccoutBalance() {
        //Given
        //When
        assertEquals(new BigDecimal("1000"), customerService.displayAccountBalanceforCustomer(CUSTOMER_ID, BANK_ACCOUNT_ID));
    }


    @Test
    public void givenCustomerIdAndtwobankAccountsThanDisplayaccoutBalance() {
        //Given
        BankAccount secondbankAccount = new BankAccount(new BigDecimal("5000"), null, customer);
        secondbankAccount.setBankAccountId(104L);
        customer.setBankAccountList(Arrays.asList(bankAccount, secondbankAccount));
        //When
        assertEquals(new BigDecimal("5000"), customerService.displayAccountBalanceforCustomer(CUSTOMER_ID, 104L));
    }

    @Test(expected = NoSuchElementException.class)
    public void givenCustomerIdAndbankAccountDifferentthanCustomerAccountThanDisplayaccoutBalance() {

        //When
        customerService.displayAccountBalanceforCustomer(CUSTOMER_ID, 123654L);
    }
}