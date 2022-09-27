package org.sid.bankaccountservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccountservice.enums.AccountType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor @Builder

public class BankAccountResponseDTO {
    private String id;

    private Date createdAt ;

    private Double balance;

    private String currency;

    private AccountType type;
}
