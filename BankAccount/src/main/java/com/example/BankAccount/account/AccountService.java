package com.example.BankAccount.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class AccountService {
    public AccountService(AccountRepository accountRepository) { this.accountRepository = accountRepository; }

    @Autowired
    private final AccountRepository accountRepository;

    public Account getAccountById(Long accountId){
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        if(accountOptional.isEmpty()){
            throw new IllegalStateException("Account Id Doesn't Exist");
        }
        return accountOptional.orElse(null);
    }
    public void createAccount(Account account){
        accountRepository.save(account);
    }

    public void addBalance(Long accountId, double amount){
        Account account = getAccountById(accountId);
        double currentBalance = account.getAccountBalance();
        double newBalance = currentBalance + amount;
        account.setAccountBalance(newBalance);
        accountRepository.save(account);


    }
    public void withdrawFromBalance(Long accountId, double amount){
        Account account = getAccountById(accountId);
        if(amount > account.getAccountBalance())
        {
           throw new IllegalStateException("Insufficient Funds.") ;
        }
        double currentBalance = account.getAccountBalance();
        double newBalance = currentBalance - amount;
        account.setAccountBalance(newBalance);
        accountRepository.save(account);
    }
}
