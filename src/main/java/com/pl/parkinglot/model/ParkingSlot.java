package com.pl.parkinglot.model;



import javax.persistence.*;

@Entity
@Table(name = "parking_slot")
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "guid")
    private String guid;



    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "status")
    private String status;

}
