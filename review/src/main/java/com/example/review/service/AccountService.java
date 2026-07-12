package com.example.review.service;

import java.util.Random;

import com.example.review.DTO.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.review.entity.Account;
import com.example.review.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    public String openAccount(Account account) {

        if (account.getBalance() < 1000) {
            return "Insufficient balance: Minimum balance should be 1000";
        }
        Random x=new Random();
        long accNo = x.nextInt(10000,10000000);

        account.setAccountNumber(accNo);
        repository.save(account);

        return "Account Opened Successfully"+accNo;
    }


    public String availService(ServiceAvail serviceAvail) {

        Account account = repository.findByAccountNumber(serviceAvail.getAccountNumber());

        if (account == null) {
            return "Account does not exist";
        }

        if (serviceAvail.getService().equalsIgnoreCase("Debit Card")) {

            if (account.isDebitCard()) {
                return "Debit Card already availed";
            }

            account.setDebitCard(true);
        }

        else if (serviceAvail.getService().equalsIgnoreCase("Cheque Book")) {

            if (account.isChequeBook()) {
                return "Cheque Book already availed";
            }

            account.setChequeBook(true);
        }

        else if (serviceAvail.getService().equalsIgnoreCase("Passbook")) {

            if (account.isPassBook()) {
                return "Passbook already availed";
            }

            account.setPassBook(true);
        }


        repository.save(account);

        return serviceAvail.getService() + " Availed Successfully";
    }

    public String deposit(DepositAndWithdraw deposit) {

        Account account = repository.findByAccountNumber(deposit.getAccountNumber());

        if (account == null) {
            return "Account does not exist";
        }

        account.setBalance(account.getBalance() + deposit.getAmount());
        repository.save(account);
        return "Amount Deposited Successfully: " + account.getBalance();
    }


    public String withdraw(DepositAndWithdraw withdraw) {
        Account account = repository.findByAccountNumber(withdraw.getAccountNumber());

        if (account == null) {
            return "Account does not exist";
        }
        if (account.getBalance() < withdraw.getAmount()) {
            return "Insufficient Balance";
        }
        account.setBalance(account.getBalance() - withdraw.getAmount());
        repository.save(account);
        return "Withdraw Successful: " + account.getBalance();

    }
    @Transactional
    public String fundtransfer(Fund fund) {

        Account account1 = repository.findByAccountNumber(fund.getSenderAccountNumber());
        if (account1 == null) {
            return "Sender Account does not exist";
        }
        Account account2 = repository.findByAccountNumber(fund.getBeneficiaryAccountNumber());
        if (account2 == null) {
            return "Beneficiary Account does not exist";
        }
        if (account1.getAccountNumber() == account2.getAccountNumber()) {
            return "Sender and Beneficiary account cannot be same";
        }
        if (account1.getBalance() < fund.getAmountTransfered()) {
            return "Insufficient Balance";
        }
        account1.setBalance(account1.getBalance() - fund.getAmountTransfered());
        account2.setBalance(account2.getBalance() + fund.getAmountTransfered());
        repository.save(account1);
        repository.save(account2);

        return "Fund Transfer Successful\nSender Balance : " + account1.getBalance() + "\nReceiver Balance : " + account2.getBalance();
    }
    @Transactional
    public String delete(Delete del) {

        Account account = repository.findByAccountNumber(del.getAccountNumber());
        if (account == null) {
            return "Account does not exist";
        }
        repository.deleteByAccountNumber(del.getAccountNumber());

        return "Account has been successfully deleted";
    }

    public String checkBalance(Delete delete) {
        Account account = repository.findByAccountNumber(delete.getAccountNumber());

        if (account == null) {
            return "Account Not Found";
        }
        return "Available Balance :" + account.getBalance();
    }

    public String updateDetails(Update update) {
        Account account = repository.findByAccountNumber(update.getAccountNumber());
        if (account == null) {
            return "Account does not exist";
        }
        account.setEmail(update.getEmail());
        account.setMobile(update.getMobile());

        repository.save(account);
        return "Email and Mobile Updated Successfully";
    }
}

