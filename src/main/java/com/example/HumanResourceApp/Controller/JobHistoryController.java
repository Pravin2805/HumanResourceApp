package com.example.HumanResourceApp.Controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HumanResourceApp.Service.JobHistoryService;

@RestController
@RequestMapping("/api/v1")
public class JobHistoryController {

	@Autowired
	JobHistoryService jhService;
	
}
