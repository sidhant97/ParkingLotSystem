package com.pl.parkinglot.service;

import com.pl.parkinglot.model.Gate;

public interface GateService {

    Gate findByStatus(String status) throws Exception;
}
