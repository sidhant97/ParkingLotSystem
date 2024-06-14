package com.pl.parkinglot.repo;

import com.pl.parkinglot.model.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSlotRepo extends JpaRepository<ParkingSlot, Integer> {
}
