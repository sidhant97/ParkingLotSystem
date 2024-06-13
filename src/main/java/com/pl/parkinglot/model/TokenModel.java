package com.pl.parkinglot.model;

import java.util.Date;

public class TokenModel {

    private String id;

    private OperatorModel operator;

    private Date entryTime;

    private Date exitTime;

    private VehicleModel vehicleModel;

    private String status;

    private ParkingSlotModel parkingSlot;
}
