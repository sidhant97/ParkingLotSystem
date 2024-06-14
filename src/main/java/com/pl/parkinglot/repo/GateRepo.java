package com.pl.parkinglot.repo;

import com.pl.parkinglot.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepo extends JpaRepository<Gate, Integer> {

}
