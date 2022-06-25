package com.job.interview.dto;

import com.job.interview.enumeration.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDTO {
    private Date transactionDate;
    private BigDecimal transactionAmount;
    private OperationType operationType;
}
