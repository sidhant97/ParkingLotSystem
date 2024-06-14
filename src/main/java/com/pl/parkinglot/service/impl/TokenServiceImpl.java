package com.pl.parkinglot.service.impl;

import com.pl.parkinglot.constant.GateType;
import com.pl.parkinglot.constant.ResponseStatus;
import com.pl.parkinglot.constant.TokenStatus;
import com.pl.parkinglot.dto.request.TokenIssueRequest;
import com.pl.parkinglot.dto.response.TokenIssueResponse;
import com.pl.parkinglot.model.Gate;
import com.pl.parkinglot.model.ParkingSlot;
import com.pl.parkinglot.model.Token;
import com.pl.parkinglot.model.VehicleAllowed;
import com.pl.parkinglot.repo.*;
import com.pl.parkinglot.service.GateService;
import com.pl.parkinglot.service.SlotAssginStartergy;
import com.pl.parkinglot.service.TokenService;
import com.pl.parkinglot.service.VehicleService;
import com.pl.parkinglot.utils.common.ParkingLotUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepo tokenRepo;

    @Autowired
    private BillRepo billRepo;

    @Autowired
    private OperatorRepo operatorRepo;

    @Autowired
    private ParkingFloorRepo parkingFloorRepo;

    @Autowired
    private ParkingLotRepo parkingLotRepo;


    @Autowired
    private ParkingSlotRepo parkingSlotRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private VehicleAllowedRepo vehicleAllowedRepo;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private GateService gateService;

    @Autowired
    private ParkingLotUtils parkingLotUtils;

    @Autowired
    private BeanFactory beanFactory;

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

    private Token generatetoken(TokenIssueRequest tokenIssueRequest) {
        Token token = new Token();
        try {
            VehicleAllowed vehicleAllowed = vehicleAllowedRepo.findByVehicleName(tokenIssueRequest.getVehicleAllowed());
            if (vehicleAllowed == null) {
                return null;
            }
            Gate gate = gateService.findByStatus(GateType.ENTRY.name());
            token.setEntryGate(gate);
            token.setEntryTime(new Date());
            token.setOperators(gate.getOperators());
            token.setGuid(parkingLotUtils.generateGuid());
            token.setStatus(TokenStatus.ACTIVE.name());
            ParkingSlot parkingSlot = getService(tokenIssueRequest.getSlotAllocation().name()).getNewSlot(vehicleAllowed, gate);
            token.setParkingSlot(parkingSlot);
            vehicleService.saveVehicle(tokenIssueRequest.getOwnerName(), tokenIssueRequest.getVehicleNumber(), vehicleAllowed.getVehicleName());
            tokenRepo.save(token);

        } catch (Exception e) {
            return null;
        }

        return token;
    }

    private SlotAssginStartergy getService(String beanName) {
        return getBean(beanName + "_SLOT_ASSGIN_STARTERGY", SlotAssginStartergy.class);
    }

    private <T> T getBean(String name, Class<T> tClass) {
        try {
            return (T) beanFactory.getBean(name);
        } catch (Exception e) {

        }
        return null;
    }
}
