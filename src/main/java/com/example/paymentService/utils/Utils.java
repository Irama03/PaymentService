package com.example.paymentService.utils;

import com.example.paymentService.models.User;

public interface Utils {

    void checkWhetherUserIsNotBanned(User user);
    void checkWhetherPaymentTypeIsAutomatic(User user);
    boolean limitOfNotPaidBillsExceeded(long quantityOfNotPaidBills);

}
