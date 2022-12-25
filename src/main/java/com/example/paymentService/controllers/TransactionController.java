package com.example.paymentService.controllers;

import com.example.paymentService.dtos.mappers.TransactionMapper;
import com.example.paymentService.dtos.transactions.TransactionGetDto;
import com.example.paymentService.services.interfaces.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/transactions")
@Validated
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionMapper mapper;

    //feature 3, feature 4, feature 5, should be called by separate planner after creation of bill;
    //separate planner is responsible for counting attempts of payment of every bill
    //(in case of failure planner will retry to pay the bill for a several days)
    @PostMapping
    public TransactionGetDto createTransaction(@RequestParam("bill_id") Long billId) {
        return mapper.transactionToTransactionGetDto(transactionService.createTransaction(billId));
    }

}
