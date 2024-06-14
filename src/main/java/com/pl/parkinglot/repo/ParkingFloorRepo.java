package com.pl.parkinglot.repo;

import com.pl.parkinglot.model.ParkingFloor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingFloorRepo extends JpaRepository<ParkingFloor, Integer> {
}
