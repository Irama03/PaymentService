package com.example.paymentService.utils;

import com.example.paymentService.exceptions.ActionForbiddenForUserException;
import com.example.paymentService.models.PaymentType;
import com.example.paymentService.models.User;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UtilsImpl implements Utils{

    private Environment environment;

    @Override
    public void checkWhetherUserIsNotBanned(User user) {
        if (user.getIsBanned())
            throw new ActionForbiddenForUserException("Action is forbidden for user with id = " + user.getId() + " because he/she is blocked");
    }

    @Override
    public void checkWhetherPaymentTypeIsAutomatic(User user) {
        if (user.getPayment() == PaymentType.MANUAL)
            throw new ActionForbiddenForUserException("Transaction for user with id = " + user.getId() + " will be not processed, because payment type is MANUAL");
    }

    @Override
    public boolean limitOfNotPaidBillsExceeded(long quantityOfNotPaidBills) {
        return quantityOfNotPaidBills >= environment.getProperty("limitOfAllowedNotPaidBills", Long.class);
    }

}
