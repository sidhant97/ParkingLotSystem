package com.pl.parkinglot.service.impl;

import com.pl.parkinglot.model.Vehicle;
import com.pl.parkinglot.repo.VehicleRepo;
import com.pl.parkinglot.service.VehicleService;
import com.pl.parkinglot.utils.common.ParkingLotUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ParkingLotUtils parkingLotUtils;

    @Override
    public Vehicle saveVehicle(String ownerName, String vehicleNumber, String vehicleType) throws Exception {
        Vehicle v = new Vehicle();
        v.setVehicleNumber(vehicleNumber);
        v.setGuid(parkingLotUtils.generateGuid());
        v.setOwnerName(ownerName);
        v.setVehicleType(vehicleType);
        vehicleRepo.save(v);
        return v;
    }
}
