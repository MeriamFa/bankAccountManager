package com.bankmanager.bankaccountmanager.repository;

import com.bankmanager.bankaccountmanager.modele.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
