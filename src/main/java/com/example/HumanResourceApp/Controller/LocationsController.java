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

import com.example.HumanResourceApp.Entity.Locations;
import com.example.HumanResourceApp.Service.LocationsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class LocationsController {

	@Autowired
	LocationsService lService;
	
	@GetMapping(value = "/location")
	public ResponseEntity<List<Locations>> getAllLocations(){
		List<Locations> locations = lService.getAllLocations(); 
		return new ResponseEntity<>(locations, HttpStatus.OK);
	}
	
	@PostMapping("/location")
	public ResponseEntity<String> addNewLocation( @Valid @RequestBody Locations location){
		Locations newLocation=lService.addNewLocation(location);
		return ResponseEntity.ok("Record Created Successfully");
	}
	
	@PutMapping("/location/{locationId}")
	public ResponseEntity<String> updateLocation( @Valid @PathVariable BigDecimal locationId, @RequestBody Locations updatedLocation){
		Locations modifiedLocation=lService.updateLocation(locationId, updatedLocation);
		//return new ResponseEntity<>(modifiedRegion,HttpStatus.OK);
		return ResponseEntity.ok("Record Modified Successfully");
	}
	
	@DeleteMapping("/location/{locationId}")
	public ResponseEntity<String> deleteLocationById ( @Valid @PathVariable BigDecimal locationId){
		lService.deleteLocationById(locationId);
		return ResponseEntity.ok("Record deleted Successfully");
	}
	
	@GetMapping("/location/{locationId}")
	public ResponseEntity<Locations> searchLocationById(@PathVariable BigDecimal locationId){
		Locations location=lService.searchLocationById(locationId);
		return ResponseEntity.ok(location);
	}
}
