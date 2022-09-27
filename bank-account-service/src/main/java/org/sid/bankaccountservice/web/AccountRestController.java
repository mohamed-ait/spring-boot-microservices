package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.BankAccountServiceApplication;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AccountRestController {
    BankAccountRepository bar;
    public AccountRestController(BankAccountRepository bankAccountRepository){
        this.bar=bankAccountRepository;
    }
    @GetMapping("/bankAccounts")
public List<BankAccount> bankAccounts(){
        return bar.findAll();
}
}
