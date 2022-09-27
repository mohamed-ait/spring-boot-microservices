package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.BankAccountServiceApplication;
import org.sid.bankaccountservice.dtos.BankAccountRequestDTO;
import org.sid.bankaccountservice.dtos.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.sid.bankaccountservice.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@RequestMapping("api")
@RestController
public class AccountRestController {
    BankAccountRepository bar;
    @Autowired
    BankAccountService bas;
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
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bard){
        return  bas.addAccount(bard);
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

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
          bar.deleteById(id);
    }

}
