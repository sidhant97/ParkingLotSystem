package com.pl.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "vehicle_allowed")
public class VehicleAllowed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_allowed_id")
    private Integer vehicleAllowedId;

    @Column(name = "vehicle_name")
    private String vehicleName;

    @ManyToMany(mappedBy = "allowedVehicles")
    private Set<ParkingLot> parkingLot = new HashSet<>();

    @ManyToMany(mappedBy = "allowedVehicles")
    private Set<ParkingSlot> parkingSlot = new HashSet<>();

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
