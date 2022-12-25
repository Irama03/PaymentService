package com.example.paymentService.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Double tariff;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PeriodType period;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentType payment;

    @NotNull
    @Column(nullable = false)
    private Boolean isBanned;

    // null if MANUAL payment
    @Embedded
    private Card card;

    @OneToMany(mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
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

    public User(Long id) {
        this.id = id;
    }

}
