package com.pl.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "parking_lot_vehicle_allowed_mapping")
public class ParkingLotVehicleAllowedMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "parking_lot_id")
    private Integer parkingLot;

    @Column(name = "vehicle_allowed_id")
    private Integer vehicleAllowedId;


}
