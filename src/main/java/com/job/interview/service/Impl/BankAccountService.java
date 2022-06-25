package com.job.interview.service.Impl;

import com.job.interview.Repository.AccountRepository;
import com.job.interview.Repository.OperationRepository;
import com.job.interview.dto.AccountDTO;
import com.job.interview.dto.OperationDTO;
import com.job.interview.dto.TransactionRequestDTO;
import com.job.interview.enumeration.BalanceType;
import com.job.interview.enumeration.OperationType;
import com.job.interview.mapper.AccountMapper;
import com.job.interview.mapper.OperationMapper;
import com.job.interview.model.Account;
import com.job.interview.model.Operation;
import com.job.interview.service.IBankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class BankAccountService implements IBankAccount {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private OperationMapper operationMapper;

    @Override
    public AccountDTO deposit(TransactionRequestDTO transactionRequestDTO) {
        Account account = accountRepository.findAccountByClient_Id(transactionRequestDTO.getIdSender());
        BigDecimal total = account.getAmount().add(transactionRequestDTO.getAmount());
        account.setAmount(total);

        if (total.compareTo(BigDecimal.valueOf(0)) > 0) {
            account.setBalance(BalanceType.CREDIT);
        } else if (total.compareTo(BigDecimal.valueOf(0)) < 0) {
            account.setBalance(BalanceType.DEBIT);
        } else {
            account.setBalance(BalanceType.ZERO);
        }
        accountRepository.save(account);
        Date date = new Date();
        Operation op = new Operation(date,transactionRequestDTO.getAmount(), OperationType.DEPOSIT,transactionRequestDTO.getIdSender(),transactionRequestDTO.getIdReciever());
        operationRepository.save(op);
        return accountMapper.toDto(account);
    }

    @Override
    public AccountDTO withdrawal(TransactionRequestDTO transactionRequestDTO) {
        Account account = accountRepository.findAccountByClient_Id(transactionRequestDTO.getIdSender());
        BigDecimal total = account.getAmount().subtract(transactionRequestDTO.getAmount());
        account.setAmount(total);

        if (total.compareTo(BigDecimal.valueOf(0)) > 0) {
            account.setBalance(BalanceType.CREDIT);
        } else if (total.compareTo(BigDecimal.valueOf(0)) < 0) {
            account.setBalance(BalanceType.DEBIT);
        } else {
            account.setBalance(BalanceType.ZERO);
        }
        accountRepository.save(account);
        Date date = new Date();
        Operation op = new Operation(date,transactionRequestDTO.getAmount(), OperationType.WITHDRAWAL,transactionRequestDTO.getIdSender(),transactionRequestDTO.getIdReciever());
        operationRepository.save(op);
        return accountMapper.toDto(account);
    }

    @Override
    public List<OperationDTO> history(Long idClient) {
        return operationMapper.toDto(operationRepository.getAllOperations(idClient));
    }
}
