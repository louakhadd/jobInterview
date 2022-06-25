package com.job.interview.dto;

import com.job.interview.enumeration.AccountType;
import com.job.interview.enumeration.BalanceType;
import com.job.interview.model.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private String accountNumber;
    private Date opendDate;
    private AccountType accountType;
    private BigDecimal amount;
    private BalanceType balance;

    private List<Operation> operations;

}
