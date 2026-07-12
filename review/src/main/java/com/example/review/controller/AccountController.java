package com.example.review.controller;

import com.example.review.DTO.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.review.entity.Account;
import com.example.review.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService service;

    @PostMapping("/open")
    public String open(@RequestBody Account account) {
        return service.openAccount(account);
    }

    @PostMapping("/service")
    public String availService(@RequestBody ServiceAvail serviceAvail) {

        return service.availService(serviceAvail);

    }

    @PostMapping("/deposit")
    public String deposit(@RequestBody DepositAndWithdraw deposit){
        return service.deposit(deposit);
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestBody DepositAndWithdraw withdraw){
        return service.withdraw(withdraw);
    }

    @PostMapping("/fundtransfer")
    public String fundtransfer(@RequestBody Fund fund){
        return service.fundtransfer(fund);
    }

    @DeleteMapping("/deleteaccount")
    public String deleteaccount(@RequestBody Delete del){
        return service.delete(del);
    }

    @PostMapping("/balance")
    public String checkBalance(@RequestBody Delete delete) {
        return service.checkBalance(delete);
    }

    @PostMapping("/update")
    public String update(@RequestBody Update update) {
        return service.updateDetails(update);
    }
}