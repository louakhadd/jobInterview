package com.job.interview.service;

import com.job.interview.dto.AccountDTO;
import com.job.interview.dto.OperationDTO;
import com.job.interview.dto.TransactionRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBankAccount {
    AccountDTO deposit(TransactionRequestDTO transactionRequestDTO);
    AccountDTO withdrawal(TransactionRequestDTO transactionRequestDTO);
    List<OperationDTO> history(Long idClient);
}
