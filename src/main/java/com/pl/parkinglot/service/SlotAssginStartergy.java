package com.pl.parkinglot.service;

import com.pl.parkinglot.model.Gate;
import com.pl.parkinglot.model.ParkingSlot;
import com.pl.parkinglot.model.VehicleAllowed;

public interface SlotAssginStartergy {

    ParkingSlot  getNewSlot(VehicleAllowed vehicleType, Gate gate) throws Exception;
}
