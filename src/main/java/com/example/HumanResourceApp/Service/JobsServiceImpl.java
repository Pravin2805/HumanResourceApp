package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HumanResourceApp.Entity.Jobs;
import com.example.HumanResourceApp.Exception.AllReadyExistsException;
import com.example.HumanResourceApp.Exception.JobNotFoundException;
import com.example.HumanResourceApp.Repository.JobsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class JobsServiceImpl implements JobsService {

	@Autowired
	JobsRepository jobsRepo;
	
	@Override
	public List<Jobs> getAllJobs() {
		return jobsRepo.findAll();
	}
	@Override
	public Jobs addNewJob(Jobs job) {
		if(jobsRepo.existsById(job.getJob_id())) {
			throw new AllReadyExistsException(null);
		}
		return jobsRepo.save(job);
	}
	@Override
	public Jobs updateJob(String jobId, Jobs updatedJob) {
		if(!jobsRepo.existsById(jobId)) {
			throw new JobNotFoundException(jobId);
		}
		Jobs existingJob=jobsRepo.findById(jobId).get();
		existingJob.setJob_title(updatedJob.getJob_title());
		existingJob.setMin_salary(updatedJob.getMin_salary());
		existingJob.setMax_salary(updatedJob.getMax_salary());
		return jobsRepo.save(existingJob);
	}
	
	@Override
	public String deleteJobById(String jobId) {
		if(!jobsRepo.existsById(jobId)) {
			throw new JobNotFoundException(jobId);
		}
		jobsRepo.deleteById(jobId);
		return " Job Deleled Succefully"; 
	}
	
	
	@Override
	public Jobs updateJobSalary(String jobId, BigDecimal minSalary, BigDecimal maxSalary) {
		if(!jobsRepo.existsById(jobId)) {
			throw new JobNotFoundException(jobId);
		}
		Jobs job=jobsRepo.findById(jobId).get();
		job.setMin_salary(minSalary);
		job.setMax_salary(maxSalary);
		return jobsRepo.save(job);
	}

}
