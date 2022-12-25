package com.example.paymentService.dtos.bills;

import com.example.paymentService.models.Card;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillForPaymentDto {

    @JsonProperty("id")
    @NotNull
    private Long id;

    @JsonProperty("amount")
    @NotNull
    private Double amount;

    @JsonProperty("card")
    @NotNull
    private Card card;
}
