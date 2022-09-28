package org.sid.bankaccountservice.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.hibernate.id.UUIDGenerator;
import org.sid.bankaccountservice.dtos.BankAccountRequestDTO;
import org.sid.bankaccountservice.dtos.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO bankAccountRequestDTO){
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountRequestDTO.getType())
                .currency(bankAccountRequestDTO.getCurrency())
                .createdAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .build();
        return bankAccount;

    }
}
