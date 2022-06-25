package com.job.interview.model;

import com.job.interview.enumeration.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Date transactionDate;
    private BigDecimal transactionAmount;
    private OperationType operationType;
    private Long idSender;
    private Long idReciever;

    public Operation(Date date, BigDecimal amount, OperationType deposit, Long l, Long l1) {
    }
}
