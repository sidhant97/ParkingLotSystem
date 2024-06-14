package com.pl.parkinglot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class VehicleAllowed extends CommonFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

}
