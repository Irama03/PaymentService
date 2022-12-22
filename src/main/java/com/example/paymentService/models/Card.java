package com.example.paymentService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @NotNull
    private Long number;

    @NotNull
    private Integer cvv;

    @NotNull
    private String expirationDate;

}
