package com.pl.parkinglot.model;


import java.util.List;

public class ParkingSlotModel {

    private Integer id;

    private List<ParkingFloorModel> parkingFloorModel;

    private  Integer capacity;

    private String status;

    private List<VehicleAllowedModel> vehicleAllowedModel;

    private List<GateModel> gates;
}
