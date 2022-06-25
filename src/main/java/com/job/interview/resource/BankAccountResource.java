package com.job.interview.resource;


import com.job.interview.dto.AccountDTO;
import com.job.interview.dto.OperationDTO;
import com.job.interview.dto.TransactionRequestDTO;
import com.job.interview.service.Impl.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/account")
@RestController
public class BankAccountResource {

    @Autowired
    private BankAccountService bankAccountService;

    @PutMapping("/deposit")
    public ResponseEntity<AccountDTO>deposit(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        return ResponseEntity.ok(bankAccountService.deposit(transactionRequestDTO));
    }

    @PutMapping("/withdrawal")
    public ResponseEntity<AccountDTO>withdrawal(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        return ResponseEntity.ok(bankAccountService.withdrawal(transactionRequestDTO));
    }

    @GetMapping("/history")
    public ResponseEntity<List<OperationDTO>> history(@RequestParam Long id) {
        return ResponseEntity.ok(bankAccountService.history(id));
    }

}
