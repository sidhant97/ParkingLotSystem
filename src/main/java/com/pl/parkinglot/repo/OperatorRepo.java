package com.pl.parkinglot.repo;

import com.pl.parkinglot.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepo extends JpaRepository<Operator, Integer> {

}
