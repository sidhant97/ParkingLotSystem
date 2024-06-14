package com.pl.parkinglot.repo;

import com.pl.parkinglot.dto.request.TokenIssueRequest;
import com.pl.parkinglot.model.ParkingLot;
import com.pl.parkinglot.model.ParkingLotVehicleAllowedMapping;
import com.pl.parkinglot.model.VehicleAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenRequestValidator {

    @Autowired
    private ParkingLotRepo parkingLotRepo;

    @Autowired
    private VehicleAllowedRepo vehicleAllowedRepo;

    @Autowired
    private ParkingLotVehicleAllowedMappingRepo parkingLotVehicleAllowedMappingRepo;

    public VehicleAllowed validateVehicleAllowed(TokenIssueRequest tokenIssueRequest){
        Optional<ParkingLot> parkingLot = parkingLotRepo.findById(tokenIssueRequest.getParkingLotId());
        Optional<VehicleAllowed> vehicleAllowed = vehicleAllowedRepo.findByVehicleName(tokenIssueRequest.getVehicleAllowed());
        if(parkingLot.isPresent() && vehicleAllowed.isPresent()) {
            Optional<ParkingLotVehicleAllowedMapping> parkingLotVehicleAllowedMapping  = parkingLotVehicleAllowedMappingRepo.findByParkingLotAndVehicleAllowed(parkingLot.get().getParkingLotId(), vehicleAllowed.get().getVehicleAllowedId());
            return parkingLotVehicleAllowedMapping.isPresent() ? vehicleAllowed.get() : null;
        }
        return null;
    }
}
