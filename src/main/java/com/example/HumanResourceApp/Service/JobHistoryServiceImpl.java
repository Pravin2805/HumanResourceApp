package com.example.HumanResourceApp.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HumanResourceApp.Repository.JobHistoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class JobHistoryServiceImpl implements JobHistoryService{

	@Autowired
	JobHistoryRepository jobHistoryRepo;
	
}
