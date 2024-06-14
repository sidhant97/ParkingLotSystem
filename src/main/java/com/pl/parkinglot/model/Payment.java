package com.pl.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymeny_id")
    private Integer paymenyId;

    @Column(name = "status")
    private String status;

    @Column(name = "amount")
    private String amount;

    @Column(name = "mode")
    private String mode;


    /*@OneToOne
    @JoinColumn(name = "token_id", referencedColumnName = "token_id")
    private Token token;

    */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_id")
    private Bill bill;

}
