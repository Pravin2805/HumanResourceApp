package com.example.HumanResourceApp.Repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HumanResourceApp.Entity.Locations;

@Repository
public interface LocationsRepository extends JpaRepository<Locations, BigDecimal> {

}
