package com.pl.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private Integer tokenId;

    @OneToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "parking_slot_id", referencedColumnName = "parking_slot_id")
    private ParkingSlot parkingSlot;

    @OneToOne
    @JoinColumn(name = "operator_id", referencedColumnName = "operator_id")
    private Operators operators;

    @Column(name = "entry_time")
    private Date entryTime;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "gate_id", referencedColumnName = "gate_id")
    private Gate entryGate;

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
