package com.example.paymentService.dtos.users;

import com.example.paymentService.models.Card;
import com.example.paymentService.models.PaymentType;
import com.example.paymentService.models.PeriodType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserGetDto {

    @JsonProperty("id")
    @NotNull
    private Long id;

    @JsonProperty("tariff")
    @NotNull
    private Double tariff;

    @JsonProperty("period")
    @NotNull
    private PeriodType period;

    @JsonProperty("payment")
    @NotNull
    private PaymentType payment;

    @JsonProperty("isBanned")
    @NotNull
    private Boolean isBanned;

    @JsonProperty("card")
    private Card card;

}
