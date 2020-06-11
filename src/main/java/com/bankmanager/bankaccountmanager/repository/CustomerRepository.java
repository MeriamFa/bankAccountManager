package com.bankmanager.bankaccountmanager.repository;

import com.bankmanager.bankaccountmanager.modele.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
