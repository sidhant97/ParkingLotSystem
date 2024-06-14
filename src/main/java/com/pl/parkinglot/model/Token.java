package com.pl.parkinglot.model;

import java.util.Date;

public class Token extends CommonFields{

    private String id;

    private Operator operator;

    private Date entryTime;

    private Date exitTime;

    private Vehicle vehicle;

    private String status;

    private ParkingSlot parkingSlot;
}
