package com.pl.parkinglot.repo;

import com.pl.parkinglot.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo extends JpaRepository<Token, Integer> {
}
