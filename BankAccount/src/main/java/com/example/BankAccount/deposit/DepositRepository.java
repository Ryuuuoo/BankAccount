package com.example.BankAccount.deposit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository
        extends JpaRepository<Deposit, Long> {
}
