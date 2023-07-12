package com.example.HumanResourceApp.Repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HumanResourceApp.Entity.Regions;

@Repository
public interface RegionsRepository extends JpaRepository<Regions, BigDecimal> {

}
