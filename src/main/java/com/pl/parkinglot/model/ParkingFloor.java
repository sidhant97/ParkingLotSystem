package com.pl.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "parking_floor")
public class ParkingFloor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_floor_id")
    private Integer parkingFloorId;


    @ManyToMany(mappedBy = "parkingFloor")
    private Set<ParkingLot> parkingLot = new HashSet<>();

    @Column(name = "floor_Name")
    private String floorName;

    @Column(name = "floor_Number")
    private Integer floorNumber;

    @Column(name = "floor_status")
    private String floorStatus;

    @Column(name = "parking_floor_capacity")
    private Integer parkingFloorCapacity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parkingFloor", cascade = CascadeType.ALL)
    private List<ParkingSlot> parkingSlot;

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
