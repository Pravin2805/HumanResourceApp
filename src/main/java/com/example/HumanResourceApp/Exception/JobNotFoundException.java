package com.example.HumanResourceApp.Exception;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;

public class JobNotFoundException extends RuntimeException {
	 
	public JobNotFoundException(String msg) {
		super(msg);
	}

}
