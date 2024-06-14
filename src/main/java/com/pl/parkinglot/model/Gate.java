package com.pl.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "gate")
public class Gate extends CommonFields {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parking_lot_id")
    ParkingLot parkingLot;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gate_id")
    private Integer gateId;
    @OneToOne
    @JoinColumn(name = "operator_id", referencedColumnName = "operator_id")
    private Operators operators;
    @Column(name = "status")
    private String status;
    @Column(name = "gate_type")
    private String gateType;
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
