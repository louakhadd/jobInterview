package com.job.interview.model;

import com.job.interview.enumeration.AccountType;
import com.job.interview.enumeration.BalanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long accountNumber;
    private Date opendDate;
    private AccountType accountType;
    private BigDecimal amount;
    private BalanceType balance;

    @OneToMany
    List<Operation> operations;

    @OneToOne
    private Client client;
}
