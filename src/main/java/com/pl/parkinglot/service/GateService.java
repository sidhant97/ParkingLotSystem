package com.pl.parkinglot.service;

import com.pl.parkinglot.model.Gate;
import com.pl.parkinglot.model.ParkingLot;

public interface GateService {

    Gate findByParkingLotAndGateType(ParkingLot parkingLot, String GateType,String status) throws Exception;
}
