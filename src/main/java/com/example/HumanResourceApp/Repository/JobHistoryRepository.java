package com.example.HumanResourceApp.Repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.HumanResourceApp.Entity.JobHistory;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, BigDecimal> {

}
