package com.pl.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "parking_floor")
public class ParkingFloor extends CommonFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_floor_id")
    private Integer parkingFloorId;

    @Column(name = "floor_Number")
    private Integer floorNumber;

    @Column(name = "floor_status")
    private String floorStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="parking_lot_id")
    ParkingLot parkingLot;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parkingFloor", cascade = CascadeType.ALL)
    private List<ParkingSlot> parkingSlot;

}
