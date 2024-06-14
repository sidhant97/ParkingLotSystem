package com.pl.parkinglot.service.impl;

import com.pl.parkinglot.model.Gate;
import com.pl.parkinglot.repo.GateRepo;
import com.pl.parkinglot.service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GateServiceImpl implements GateService {

    @Autowired
    private GateRepo gateRepo;


    public Gate findByStatus(String status){
       return gateRepo.findByStatus(status);
    }
}
