package com.example.paymentService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @NotNull
    @Column(name = "card_number")
    private Long number;

    @NotNull
    @Column(name = "card_cvv")
    private Integer cvv;

    @NotNull
    @Column(name = "card_expiration_date")
    private String expirationDate;

}
