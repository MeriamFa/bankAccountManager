package com.bankmanager.bankaccountmanager.repository;

import com.bankmanager.bankaccountmanager.modele.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
}
