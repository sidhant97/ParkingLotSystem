package com.pl.parkinglot.repo;

import com.pl.parkinglot.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepo extends JpaRepository<ParkingLot, Integer> {
}
