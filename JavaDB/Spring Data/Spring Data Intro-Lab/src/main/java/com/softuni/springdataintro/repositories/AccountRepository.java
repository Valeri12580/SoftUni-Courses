package com.softuni.springdataintro.repositories;

import com.softuni.springdataintro.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findAccountById(Long id);


}
