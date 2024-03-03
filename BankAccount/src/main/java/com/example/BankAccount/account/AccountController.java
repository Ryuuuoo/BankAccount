package com.example.BankAccount.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){this.accountService = accountService ;}


    private long depositTransactionId = 0;

    private long withdrawalTransactionId = 0;

    @GetMapping("/{accountId}")
    public Account getAccountById(@PathVariable("accountId") Long accountId){
        return accountService.getAccountById(accountId);
    }

    @PostMapping
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);}

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<String> deposit(@PathVariable("accountId")Long accountId,
                        @RequestParam double amount){
        accountService.addBalance(accountId,amount);
        depositTransactionId++;
        return ResponseEntity.ok("Deposit successful for account " + getAccountById(accountId).getAccountName() + "\n" + " for Amount:" + amount + "\n" + " Transaction ID: " + depositTransactionId);
    }

    @PostMapping("{accountId}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable("accountId")Long accountId,
                                   @RequestParam double amount){
        accountService.withdrawFromBalance(accountId,amount);
        withdrawalTransactionId++;
        return ResponseEntity.ok("Withdrawal successful for account " + getAccountById(accountId).getAccountName() + "\n" + " for Amount:" + amount + "\n" + " Transaction ID: " + withdrawalTransactionId);
    }
}
