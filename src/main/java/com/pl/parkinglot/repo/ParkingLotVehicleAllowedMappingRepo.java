package com.pl.parkinglot.repo;

import com.pl.parkinglot.model.ParkingLotVehicleAllowedMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingLotVehicleAllowedMappingRepo extends JpaRepository<ParkingLotVehicleAllowedMapping, Integer> {

    @Query("Select a from ParkingLotVehicleAllowedMapping a where a.parkingLot =:parkingLot and a.vehicleAllowedId=:vehicleAllowedId")
    Optional<ParkingLotVehicleAllowedMapping> findByParkingLotAndVehicleAllowed(@Param("parkingLot") Integer parkingLot,@Param("vehicleAllowedId") Integer vehicleAllowedId);


}
