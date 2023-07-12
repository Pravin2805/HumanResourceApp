package com.example.HumanResourceApp.Controller;

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

import com.example.HumanResourceApp.Entity.Countries;
import com.example.HumanResourceApp.Entity.Jobs;
import com.example.HumanResourceApp.Service.CountriesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CountriesController {

	@Autowired
	CountriesService cService;
	
	@PostMapping("/country")
	public ResponseEntity<String> addNewCountry( @Valid @RequestBody Countries country){
		Countries newCountry=cService.addNewCountry(country);
		//return new ResponseEntity<>(newCountry,HttpStatus.CREATED);
		return ResponseEntity.ok("Record Created Successfully");
	}
	
	@PutMapping("/country/{countryId}")
	public ResponseEntity<String> updateCountry( @Valid @PathVariable String countryId, @RequestBody Countries updatedCountry){
		Countries modifiedCountry=cService.updateCountry(countryId, updatedCountry);
		//return new ResponseEntity<>(modifiedCountry,HttpStatus.OK);
		return ResponseEntity.ok("Record Modified Successfully");
	}
	
	@DeleteMapping("/country/{countryId}")
	public ResponseEntity<String> deleteCountryById(@Valid @PathVariable String countryId){
		cService.deleteCountryById(countryId);
		return ResponseEntity.ok("Record deleted Successfully");
	}
	
	@GetMapping("/country/{countryId}")
	public ResponseEntity<Countries> searchCountryById(@PathVariable String countryId){
		Countries country=cService.searchCountryById(countryId);
		return ResponseEntity.ok(country);
	}
	
	@GetMapping("/country")
	public ResponseEntity<List<Countries>> getAllCountries(){
		List<Countries> countries = cService.getAllCountries(); 
		return ResponseEntity.ok(countries);
	}
	
	
}
