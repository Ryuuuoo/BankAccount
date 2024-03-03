package com.example.BankAccount.deposit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService {
    public DepositService(DepositRepository depositRepository){this.depositRepository = depositRepository ;}

    @Autowired
    private final DepositRepository depositRepository;


}
