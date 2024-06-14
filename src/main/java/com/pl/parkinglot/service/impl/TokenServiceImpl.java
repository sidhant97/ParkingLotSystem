package com.pl.parkinglot.service.impl;

import com.pl.parkinglot.constant.GateStatus;
import com.pl.parkinglot.constant.GateType;
import com.pl.parkinglot.constant.ResponseStatus;
import com.pl.parkinglot.constant.TokenStatus;
import com.pl.parkinglot.dto.request.TokenIssueRequest;
import com.pl.parkinglot.dto.response.TokenIssueResponse;
import com.pl.parkinglot.model.*;
import com.pl.parkinglot.repo.ParkingLotRepo;
import com.pl.parkinglot.repo.TokenRepo;
import com.pl.parkinglot.repo.TokenRequestValidator;
import com.pl.parkinglot.service.GateService;
import com.pl.parkinglot.service.TokenService;
import com.pl.parkinglot.service.VehicleService;
import com.pl.parkinglot.utils.common.ParkingLotUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepo tokenRepo;

    @Autowired
    private ParkingLotRepo parkingLotRepo;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private GateService gateService;

    @Autowired
    private TokenRequestValidator tokenRequestValidator;

    @Autowired
    private ParkingLotUtils parkingLotUtils;

    @Override
    public TokenIssueResponse entryParking(TokenIssueRequest tokenIssueRequest) {
        TokenIssueResponse tokenIssueResponse = new TokenIssueResponse();
        try {
            Token token = generatetoken(tokenIssueRequest);
            if (token != null) {
                tokenIssueResponse.setToken(token);
                tokenIssueResponse.setResponseStatus(ResponseStatus.SUCCESS);
            }
        } catch (Exception e) {
            tokenIssueResponse.setResponseStatus(ResponseStatus.FAILED);
            tokenIssueResponse.setFailureMsg("Something went wrong.");
        }
        return tokenIssueResponse;
    }

    @Override
    public TokenIssueResponse exitParking(TokenIssueRequest tokenIssueRequest) throws Exception {
        TokenIssueResponse tokenIssueResponse = new TokenIssueResponse();
        try {

        } catch (Exception e) {
            return null;
        }
        return tokenIssueResponse;
    }

    private Token generatetoken(TokenIssueRequest tokenIssueRequest) throws Exception {
        Token token = null;
        try {
            VehicleAllowed vehicleAllowed = tokenRequestValidator.validateVehicleAllowed(tokenIssueRequest);
            if (vehicleAllowed == null) {
                return null;
            }
            token = new Token();
            Optional<ParkingLot> parkingLot = parkingLotRepo.findById(tokenIssueRequest.getParkingLotId());
            Gate gate = gateService.findByParkingLotAndGateType(parkingLot.get(), GateType.ENTRY.name(), GateStatus.OPEN.name());
            token.setEntryGate(gate);
            token.setEntryTime(new Date());
            token.setOperators(gate.getOperators());
            token.setGuid(parkingLotUtils.generateGuid());
            token.setStatus(TokenStatus.ACTIVE.name());
            ParkingSlot parkingSlot = parkingLotUtils.getSlotAssginStartergyService(tokenIssueRequest.getSlotAllocation().name())
                    .getNewSlot(vehicleAllowed, gate);
            token.setParkingSlot(parkingSlot);
            Vehicle vehicle = vehicleService.saveVehicle(tokenIssueRequest.getOwnerName(),
                    tokenIssueRequest.getVehicleNumber(), vehicleAllowed.getVehicleName());
            token.setVehicle(vehicle);
            tokenRepo.save(token);
        } catch (Exception e) {
            return null;
        }

        return token;
    }
}
