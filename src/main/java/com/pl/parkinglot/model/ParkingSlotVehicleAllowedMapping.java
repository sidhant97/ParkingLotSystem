package com.pl.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "parking_slot_vehicle_allowed_mapping")
public class ParkingSlotVehicleAllowedMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "parking_slot_id")
    private Integer parkingSlot;

    @Column(name = "vehicle_allowed_id")
    private Integer vehicleAllowedId;


}
