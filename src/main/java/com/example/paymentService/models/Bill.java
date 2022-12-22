package com.example.paymentService.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @NotNull
    private Double amount;

    @NotNull
    private Date creationDate;

    //null if not paid yet
    private Date paymentDate;

    @OneToMany(mappedBy = "bill")
    private Set<Transaction> transactions;

    public Bill(Long id, User user, Double amount, Date creationDate, Date paymentDate) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.creationDate = creationDate;
        this.paymentDate = paymentDate;
    }

    public Bill(User user, Double amount, Date creationDate, Date paymentDate) {
        this.user = user;
        this.amount = amount;
        this.creationDate = creationDate;
        this.paymentDate = paymentDate;
    }

}
