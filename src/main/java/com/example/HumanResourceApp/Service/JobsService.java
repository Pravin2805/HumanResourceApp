package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;
import java.util.List;

import com.example.HumanResourceApp.Entity.Jobs;

public interface JobsService {
	public List<Jobs> getAllJobs();
	public Jobs addNewJob(Jobs job);
	public Jobs updateJob(String jobId, Jobs updatedJob);
	public String deleteJobById(String jobId);
	public Jobs updateJobSalary(String jobId, BigDecimal minSalary, BigDecimal maxSalary);
}
