package com.bankmanager.bankaccountmanager.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT_TRANSACTION")
public class AccountTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountTransactionId;

    @Column(name = "ACCOUNT_TRANSACTION_DATE")
    private Date accountTransaction_Date;

    @Column(name = "ACCOUNT_TRANSACTION_DESCR")
    private String accountTransaction_Description;

    @Column(name = "ACCOUNT_TRANSACTION_AMOUNT")
    private Double acountTransaction_Amount;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bankAccountId")
    private BankAccount bankAccount;

    public AccountTransaction() {

    }

    public AccountTransaction(Date accountTransaction_Date, String accountTransaction_Description, double acountTransaction_Amount, BankAccount bankAccount) {
        this.accountTransaction_Date = accountTransaction_Date;
        this.accountTransaction_Description = accountTransaction_Description;
        this.acountTransaction_Amount = acountTransaction_Amount;
        this.bankAccount = bankAccount;
    }

    public Long getAccountTransactionId() {
        return accountTransactionId;
    }

    public void setAccountTransactionId(Long accountTransactionId) {
        this.accountTransactionId = accountTransactionId;
    }

    public Date getAccountTransaction_Date() {
        return accountTransaction_Date;
    }

    public void setAccountTransaction_Date(Date accountTransaction_Date) {
        this.accountTransaction_Date = accountTransaction_Date;
    }

    public String getAccountTransaction_Description() {
        return accountTransaction_Description;
    }

    public void setAccountTransaction_Description(String accountTransaction_Description) {
        this.accountTransaction_Description = accountTransaction_Description;
    }

    public double getAcountTransaction_Amount() {
        return acountTransaction_Amount;
    }

    public void setAcountTransaction_Amount(double acountTransaction_Amount) {
        this.acountTransaction_Amount = acountTransaction_Amount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "AccountTransaction{" + "accountTransactionId=" + accountTransactionId + ", accountTransaction_Date=" + accountTransaction_Date + ", accountTransaction_Description='" + accountTransaction_Description + '\'' + ", acountTransaction_Amount=" + acountTransaction_Amount + ", bankAccount=" + bankAccount + '}';
    }
}
