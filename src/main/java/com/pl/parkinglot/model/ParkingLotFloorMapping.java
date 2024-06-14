package com.pl.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "parking_lot_floor_Mapping")
public class ParkingLotFloorMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "parking_lot_id")
    private Integer parkingLot;

    @Column(name = "parking_floor_id")
    private Integer parkingFloorId;


}
