package com.example.HumanResourceApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HumanResourceApp.Entity.Jobs;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, String>{

}
