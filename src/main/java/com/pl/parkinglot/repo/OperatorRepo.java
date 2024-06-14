package com.pl.parkinglot.repo;

import com.pl.parkinglot.model.Operators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepo extends JpaRepository<Operators, Integer> {

}
