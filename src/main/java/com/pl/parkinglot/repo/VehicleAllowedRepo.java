package com.pl.parkinglot.repo;

import com.pl.parkinglot.model.VehicleAllowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleAllowedRepo extends JpaRepository<VehicleAllowed,Integer> {

    @Query("Select a from VehicleAllowed a where a.isActive = 1 and a.isDelete = 0 and a.vehicleName=:vehicleName")
    VehicleAllowed findByVehicleName(@Param("vehicleName") String vehicleName);
}
