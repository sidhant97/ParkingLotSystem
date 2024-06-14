package com.pl.parkinglot.utils.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class ParkingLotUtils {

    Logger logger = LoggerFactory.getLogger(ParkingLotUtils.class);

    public String generateGuid(){
        return UUID.randomUUID().toString();
    }

}
