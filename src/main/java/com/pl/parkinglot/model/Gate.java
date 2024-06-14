package com.pl.parkinglot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "guid")
    private String guid;


    private Operator operator;

    @Column(name = "status")
    private String status;

    @Column(name = "gate_type")
    private String gateType;



}
