package com.pl.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Integer billId;

    @OneToOne
    @JoinColumn(name = "token_id", referencedColumnName = "token_id")
    private Token token;

    @OneToOne
    @JoinColumn(name = "gate_id", referencedColumnName = "gate_id")
    private Gate exitGate;

    @OneToOne
    @JoinColumn(name = "operator_id", referencedColumnName = "operator_id")
    private Operators operator;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bill", cascade = CascadeType.ALL)
    private List<Payment> payment;

    @Column(name = "status")
    private String status;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "exit_time")
    private Date exitTime;

    @Column(name = "guid", unique = true)
    private String guid;

    @Column(name = "isactive")
    private short isActive = 1;

    @Column(name = "isdelete")
    private short isDelete = 0;

    @Column(name = "createddate")
    private Date createdDate = new Date();

    @Column(name = "modifieddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate = new Date();


}
