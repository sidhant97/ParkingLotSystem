package com.pl.parkinglot.service;

import com.pl.parkinglot.model.Vehicle;

public interface VehicleService {

    Vehicle saveVehicle(String ownerName, String vehicleNumber, String vehicleType) throws Exception;
}
