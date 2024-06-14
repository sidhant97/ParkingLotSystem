package com.pl.parkinglot.repo;

import com.pl.parkinglot.model.Gate;
import com.pl.parkinglot.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepo extends JpaRepository<Gate, Integer> {

    @Query("Select a from Gate a where a.isActive = 1 and a.isDelete = 0 and a.parkingLot=:parkingLot and a.gateType=:gateType and a.status=:status")
    Gate findByParkingLotAndGateType(@Param("parkingLot")ParkingLot parkingLot, @Param("gateType") String gateType,@Param("status") String status);
}
