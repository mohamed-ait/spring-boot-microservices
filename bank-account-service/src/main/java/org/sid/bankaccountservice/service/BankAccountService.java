package org.sid.bankaccountservice.service;

import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.enums.AccountType;

public interface BankAccountService {
    public BankAccount addAccount(Double initialBalance, AccountType type)
}
