package com.pl.parkinglot.model;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parking_slot")
@Getter
@Setter
public class ParkingSlot extends CommonFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_slot_id")
    private Integer parkingSlotId;

    @Column(name = "parking_slot_capacity")
    private Integer parkingSlotCapacity;

    @Column(name = "parking_slot_status")
    private String parkingSlotStatus;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="parking_floor_id")
    ParkingFloor parkingFloor;

}
