package com.example.paymentService.services.interfaces;

import com.example.paymentService.models.Bill;
import com.example.paymentService.models.Transaction;
import com.example.paymentService.models.User;

public interface BillService {

    Bill getBillById(Long id);
    Iterable<Bill> getBillsOfUser(Long userId);

    Bill createBillOfUser(Long userId);

    Transaction getSuccessfulTransaction(Bill bill);

    long getQuantityOfNotPaidBills(User user);
}
