package com.pl.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "parking_lot")
public class ParkingLot extends CommonFields {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parkingLot", cascade = CascadeType.ALL)
    List<VehicleAllowed> allowedVehicles;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_lot_id")
    private Integer parkingLotId;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "status")
    private String status;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<ParkingFloor> parkingFloor;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<Gate> gates;


}
