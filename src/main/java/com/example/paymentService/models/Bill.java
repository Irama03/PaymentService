package com.example.paymentService.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @Column(name = "bill_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Column(nullable = false)
    private Double amount;

    @NotNull
    @Column(nullable = false)
    private Date creationDate;

    @OneToMany(mappedBy = "bill")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Transaction> transactions;

    public Bill(Long id, User user, Double amount, Date creationDate) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.creationDate = creationDate;
    }

    public Bill(User user, Double amount, Date creationDate) {
        this.user = user;
        this.amount = amount;
        this.creationDate = creationDate;
    }

    public Bill(Long id) {
        this.id = id;
    }

}
