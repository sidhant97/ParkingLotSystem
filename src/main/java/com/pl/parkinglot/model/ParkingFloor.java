package com.pl.parkinglot.model;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

@Entity
@Data
public class ParkingFloor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "guid")
    private String guid;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "parking_lot_id")
//    private ParkingLot parkinglot;



//    private List<ParkingSlot> parkingSlots;


    @Column(name = "floor_Number")
    private Integer floorNumber;

    @Column(name = "status")
    private String status;


}
