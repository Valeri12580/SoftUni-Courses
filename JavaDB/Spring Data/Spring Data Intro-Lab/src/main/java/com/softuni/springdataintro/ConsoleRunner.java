package com.softuni.springdataintro;

import com.softuni.springdataintro.models.Account;
import com.softuni.springdataintro.models.User;
import com.softuni.springdataintro.services.AccountService;
import com.softuni.springdataintro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        User user=new User("Valeri",19);
        Account account=new Account();
        account.setBalance(new BigDecimal("2000"));

        user.setAccounts(new HashSet<>(){{add(account);}});

        userService.registerUser(user);

        this.accountService.withdrawMoney(new BigDecimal("1000"),account.getId());

    }
}
