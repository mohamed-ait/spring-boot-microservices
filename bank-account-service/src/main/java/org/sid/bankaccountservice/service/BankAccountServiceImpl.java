package org.sid.bankaccountservice.service;

import io.swagger.v3.oas.annotations.servers.Server;
import org.sid.bankaccountservice.dtos.BankAccountRequestDTO;
import org.sid.bankaccountservice.dtos.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.mappers.AccountMapper;
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
    @Autowired
    AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount=accountMapper.fromBankAccountRequestDTO(bankAccountRequestDTO);
     bar.save(bankAccount);
     BankAccountResponseDTO bankAccountResponseDTO=accountMapper.fromBankAccount(bankAccount);
        return bankAccountResponseDTO;
    }
}
