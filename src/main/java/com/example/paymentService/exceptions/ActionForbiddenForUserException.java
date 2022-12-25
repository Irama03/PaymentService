package com.example.paymentService.exceptions;

public class ActionForbiddenForUserException extends RuntimeException {

    public ActionForbiddenForUserException(String description) {
        super(description);
    }

}
