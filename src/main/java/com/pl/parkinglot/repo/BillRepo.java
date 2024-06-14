package com.pl.parkinglot.repo;

import com.pl.parkinglot.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill, Integer> {

}
