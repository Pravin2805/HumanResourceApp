package com.example.HumanResourceApp.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HumanResourceApp.Entity.Jobs;
import com.example.HumanResourceApp.Service.JobsService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1")
public class JobsController {

	@Autowired
	JobsService jService;
	
	@GetMapping("/job")
	public ResponseEntity<List<Jobs>> getAllJobs(){
		List<Jobs> jobs = jService.getAllJobs(); 
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}
	
	@PostMapping("/job")
	public ResponseEntity<String> addNewJob(@Valid @RequestBody Jobs job){
		jService.addNewJob(job);
		return ResponseEntity.ok("Record Created Successfully");
	}
	
	@PutMapping("/job/{jobId}")
	public ResponseEntity<String> updateJob( @Valid @PathVariable String jobId, @RequestBody Jobs updatedJob){
		jService.updateJob(jobId, updatedJob);
		return ResponseEntity.ok("Record Modified Successfully");
	}
	
	@DeleteMapping("/job/{jobId}")
	public ResponseEntity<String> deleteJobById(@PathVariable String jobId){
		jService.deleteJobById(jobId);
		return ResponseEntity.ok("Record deleted Successfully");
	}
	
	public ResponseEntity<Jobs> updateJobSalary(@PathVariable String jobId,@PathVariable BigDecimal minSalary,@PathVariable BigDecimal maxSalary){
		Jobs updatedJob=jService.updateJobSalary(jobId, minSalary, maxSalary);
		return ResponseEntity.ok(updatedJob);
	}
}
