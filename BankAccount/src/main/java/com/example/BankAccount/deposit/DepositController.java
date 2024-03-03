package com.example.BankAccount.deposit;

import com.example.BankAccount.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DepositController {
    private final DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService){this.depositService = depositService ;}
}
