package com.example.paymentService.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Double tariff;

    @NotNull
    private PeriodType period;

    @NotNull
    private PaymentType payment;

    @NotNull
    private Boolean isBanned;

    // null if MANUAL payment
    @Embedded
    private Card card;

    @OneToMany(mappedBy = "user")
    private Set<Bill> bills;

    public User(Long id, Double tariff, PeriodType period, PaymentType payment, Boolean isBanned, Card card) {
        this.id = id;
        this.tariff = tariff;
        this.period = period;
        this.payment = payment;
        this.isBanned = isBanned;
        this.card = card;
    }

    public User(Double tariff, PeriodType period, PaymentType payment, Boolean isBanned, Card card) {
        this.tariff = tariff;
        this.period = period;
        this.payment = payment;
        this.isBanned = isBanned;
        this.card = card;
    }

}
