package com.pl.parkinglot.repo;

import com.pl.parkinglot.model.VehicleAllowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleAllowedRepo extends JpaRepository<VehicleAllowed,Integer> {
}
