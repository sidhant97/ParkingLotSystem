package com.pl.parkinglot.service.impl;

import com.pl.parkinglot.model.Gate;
import com.pl.parkinglot.model.ParkingSlot;
import com.pl.parkinglot.model.VehicleAllowed;
import com.pl.parkinglot.repo.*;
import com.pl.parkinglot.service.SlotAssginStartergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("DEFAULT_SLOT_ASSGIN_STARTERGY")
public class DefaultSlotAssginStartergy implements SlotAssginStartergy {


    @Autowired
    private BillRepo billRepo;


    @Autowired
    private ParkingFloorRepo parkingFloorRepo;

    @Autowired
    private ParkingLotRepo parkingLotRepo;


    @Autowired
    private ParkingSlotRepo parkingSlotRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public ParkingSlot getNewSlot(VehicleAllowed vehicleType, Gate gate) throws Exception {
        return null;
    }
}
