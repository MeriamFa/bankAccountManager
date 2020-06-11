package com.bankmanager.bankaccountmanager.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "BANKACCOUNT")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankAccountId;

    @Column(name = "ACCOUNT_BALANCE")
    private BigDecimal accountBalance;

    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountTransaction> accountTransactionList;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public BankAccount() {

    }

    public BankAccount(BigDecimal accountBalance, List<AccountTransaction> accountTransactionList, Customer customer) {
        this.accountBalance = accountBalance;
        this.accountTransactionList = accountTransactionList;
        this.customer = customer;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<AccountTransaction> getAccountTransactionList() {
        return accountTransactionList;
    }

    public void setAccountTransactionList(List<AccountTransaction> accountTransactionList) {
        this.accountTransactionList = accountTransactionList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "bankAccountId=" + bankAccountId + ", accountBalance=" + accountBalance + ", accountTransactionList=" + accountTransactionList + ", customer=" + customer + '}';
    }
}