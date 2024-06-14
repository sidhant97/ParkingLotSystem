package com.pl.parkinglot.model;

import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "guid")
    private String guid;


//    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ParkingFloor> parkingFloor = new ArrayList<>();

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "status")
    private String status;

//    @Column(name = "gate")
//    private List<Gate> gates;
//
//    List<VehicleType> allowedVehicles;




}
