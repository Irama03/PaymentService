package com.example.paymentService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @NotNull
    @Column(nullable = false)
    private Date processDate;

    // when becomes true, paymentDate in Bill becomes equal processDate of this Transaction
    @NotNull
    @Column(nullable = false)
    private Boolean isSuccessful;

    public Transaction(Bill bill, Date processDate, boolean isSuccessful) {
        this.bill = bill;
        this.processDate = processDate;
        this.isSuccessful = isSuccessful;
    }

}
