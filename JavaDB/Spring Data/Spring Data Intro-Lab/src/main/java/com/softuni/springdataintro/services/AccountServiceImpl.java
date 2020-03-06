package com.softuni.springdataintro.services;

import com.softuni.springdataintro.models.Account;
import com.softuni.springdataintro.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;



    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        Account acc=accountRepository.findAccountById(id);
        acc.setBalance(acc.getBalance().subtract(money));
        accountRepository.save(acc);
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {

    }
}
