package com.pl.parkinglot.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "parking_slot")
@Getter
@Setter
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_slot_id")
    private Integer parkingSlotId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parking_floor_id")
    ParkingFloor parkingFloor;

    @Column(name = "parking_slot_status")
    private String parkingSlotStatus;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "parking_slot_vehicle_allowed_Mapping",
            joinColumns = @JoinColumn(name = "parking_slot_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    Set<VehicleAllowed> allowedVehicles = new HashSet<>();

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
