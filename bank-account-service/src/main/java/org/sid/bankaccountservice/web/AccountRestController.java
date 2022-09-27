package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.BankAccountServiceApplication;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    @GetMapping("/bankAccounts/{id}")
public BankAccount bankAccount(@PathVariablec String id ){
        return bar.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
}
}
