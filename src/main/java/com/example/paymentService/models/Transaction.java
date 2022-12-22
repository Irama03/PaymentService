package com.example.paymentService.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    private Bill bill;

    @NotNull
    private Long processDate;

    // when becomes true, paymentDate in Bill becomes equal processDate of this Transaction
    @NotNull
    private boolean isSuccessful;

    public Transaction(Long id, Bill bill, Long processDate, boolean isSuccessful) {
        this.id = id;
        this.bill = bill;
        this.processDate = processDate;
        this.isSuccessful = isSuccessful;
    }

    public Transaction(Bill bill, Long processDate, boolean isSuccessful) {
        this.bill = bill;
        this.processDate = processDate;
        this.isSuccessful = isSuccessful;
    }

}
