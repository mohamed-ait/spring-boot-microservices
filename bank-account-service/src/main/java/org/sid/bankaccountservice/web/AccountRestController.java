package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.BankAccountServiceApplication;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
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
public BankAccount bankAccount(@PathVariable String id ){
        return bar.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
}
@PostMapping("/bankAccounts")
    public BankAccount save( @RequestBody BankAccount ba){
        return  bar.save(ba);
}
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id , @RequestBody BankAccount ba){
        BankAccount  account = bar.findById(id).orElseThrow();
       if(ba.getBalance()!=null) account.setBalance(ba.getBalance());
       if(ba.getType()!=null) account.setType(ba.getType());
        if(ba.getCreatedAt()!=null)  account.setCurrency(ba.getCurrency());
        if(ba.getType()!=null)  account.setCreatedAt(ba.getCreatedAt());
        return  bar.save(account);
    }

}
