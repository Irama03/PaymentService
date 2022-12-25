package com.example.paymentService.services.implementations;

import com.example.paymentService.apiCommunication.BankWebClient;
import com.example.paymentService.models.Bill;
import com.example.paymentService.models.Transaction;
import com.example.paymentService.models.User;
import com.example.paymentService.repositories.TransactionRepository;
import com.example.paymentService.services.interfaces.BillService;
import com.example.paymentService.services.interfaces.TransactionService;
import com.example.paymentService.services.interfaces.UserService;
import com.example.paymentService.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private BillService billService;
    private UserService userService;
    private Utils utils;
    private BankWebClient bankWebClient;

    //feature 3, feature 4, feature 5
    @Override
    public Transaction createTransaction(Long billId) {
        Bill bill = billService.getBillById(billId);
        User user = bill.getUser();
        utils.checkWhetherUserIsNotBanned(user);
        utils.checkWhetherPaymentTypeIsAutomatic(user);

        //If bill is already paid, existing successful transaction is returned
        Transaction transaction = billService.getSuccessfulTransaction(bill);
        if (transaction != null)
            return transaction;

        boolean transactionIsSuccessful = bankWebClient.tryToPayBill(bill);
        transaction = transactionRepository.save(
                new Transaction(bill, new Date(), transactionIsSuccessful));

        //If limit of not paid bills exceeded, user becomes banned
        if (!transactionIsSuccessful)
            checkWhetherUserNeedsToBeBanned(user);

        return transaction;
    }

    private void checkWhetherUserNeedsToBeBanned(User user) {
        long quantityOfNotPaidBills = billService.getQuantityOfNotPaidBills(user);
        if (utils.limitOfNotPaidBillsExceeded(quantityOfNotPaidBills + 1))
            userService.banUser(user.getId());
    }

}
