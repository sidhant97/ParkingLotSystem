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
@Table(name = "parking_lot")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_lot_id")
    private Integer parkingLotId;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "status")
    private String status;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "parking_lot_floor_Mapping",
            joinColumns = @JoinColumn(name = "parking_lot_id"),
            inverseJoinColumns = @JoinColumn(name = "parking_floor_id"))
    private Set<ParkingFloor> parkingFloor = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<Gate> gates;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "parking_lot_vehicle_allowed_Mapping",
            joinColumns = @JoinColumn(name = "parking_lot_id"),
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
