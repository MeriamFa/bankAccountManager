package com.bankmanager.bankaccountmanager.modele;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "CUSTOMER_FIRST_NAME")
    private String customerFirstName;

    @Column(name = "CUSTOMER_LAST_NAME")
    private String customerLastName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BankAccount> bankAccountList;

    public Customer() {

    }

    public Customer(String customerFirstName, String customerLastName, List<BankAccount> bankAccountList) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.bankAccountList = bankAccountList;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerFirstName='" + customerFirstName + '\'' + ", customerLastName='" + customerLastName + '\'' + '}';
    }
}
