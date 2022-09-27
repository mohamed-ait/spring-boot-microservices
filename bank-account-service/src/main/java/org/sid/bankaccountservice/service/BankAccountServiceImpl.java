package org.sid.bankaccountservice.service;

import io.swagger.v3.oas.annotations.servers.Server;
import org.sid.bankaccountservice.dtos.BankAccountRequestDTO;
import org.sid.bankaccountservice.dtos.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service @Transactional
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    BankAccountRepository bar;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .type(bankAccountRequestDTO.getType())
                .build();
     bar.save(bankAccount);
     BankAccountResponseDTO bankAccountResponseDTO=BankAccountResponseDTO.builder()
             .id(bankAccount.getId())
             .balance(bankAccount.getBalance())
             .createdAt(bankAccount.getCreatedAt())
             .currency(bankAccount.getCurrency())
             .type(bankAccount.getType())
             .build();
        return bankAccountResponseDTO;
    }
}
