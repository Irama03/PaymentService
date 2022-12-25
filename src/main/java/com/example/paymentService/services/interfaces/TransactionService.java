package com.example.paymentService.services.interfaces;

import com.example.paymentService.models.Transaction;

public interface TransactionService {

    Transaction createTransaction(Long billId);

}
