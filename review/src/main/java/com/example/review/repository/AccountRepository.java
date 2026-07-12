package com.example.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.review.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByAccountNumber(long accountNumber);
    void deleteByAccountNumber(long accountNumber);
}