package com.pl.parkinglot.service.impl;

import com.pl.parkinglot.model.Gate;
import com.pl.parkinglot.model.ParkingSlot;
import com.pl.parkinglot.model.VehicleAllowed;
import org.springframework.stereotype.Service;

@Service("VIP_SLOT_ASSGIN_STARTERGY")
public class VIPSlotAssginStartergy extends DefaultSlotAssginStartergy {
    @Override
    public ParkingSlot getNewSlot(VehicleAllowed vehicleType, Gate gate) throws Exception {
        return null;
    }
}
