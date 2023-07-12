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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.HumanResourceApp.Entity.Countries;
import com.example.HumanResourceApp.Entity.Regions;
import com.example.HumanResourceApp.Service.RegionsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class RegionsController {
	
	@Autowired
	RegionsService rService;

	@GetMapping(value = "/region")
	public ResponseEntity<List<Regions>> getAllRegions(){
		List<Regions> regions = rService.getAllRegions(); 
		return new ResponseEntity<>(regions, HttpStatus.OK);
	}
	
	@PostMapping("/region")
	public ResponseEntity<String> addNewRegion( @Valid @RequestBody Regions region){
		Regions newRegion=rService.addNewRegion(region);
		return ResponseEntity.ok("Record Created Successfully");
	}
	
	@PutMapping("/region/{regionId}")
	public ResponseEntity<String> updateRegion( @Valid @PathVariable BigDecimal regionId, @RequestBody Regions updatedRegion){
		Regions modifiedRegion=rService.updateRegion(regionId, updatedRegion);
		return ResponseEntity.ok("Record Modified Successfully");
	}
	
	@DeleteMapping("/region/{regionId}")
	public ResponseEntity<String> deleteRegionById(@PathVariable BigDecimal regionId){
		rService.deleteRegionById(regionId);
		return ResponseEntity.ok("Record deleted Successfully");
	}
	
	@GetMapping("/region/{regionId}")
	public ResponseEntity<Regions> searchRegionById(@PathVariable BigDecimal regionId){
		Regions region=rService.searchRegionById(regionId);
		return ResponseEntity.ok(region);
	}
}
