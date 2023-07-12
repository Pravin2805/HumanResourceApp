package com.example.HumanResourceApp.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HumanResourceApp.Entity.Countries;
import com.example.HumanResourceApp.Exception.AllReadyExistsException;
import com.example.HumanResourceApp.Exception.CountryNotFoundException;
import com.example.HumanResourceApp.Exception.EmptyInputException;
import com.example.HumanResourceApp.Repository.CountriesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CountriesServiceImpl implements CountriesService{

	@Autowired
	CountriesRepository countriesRepo;

	@Override
	public Countries addNewCountry(Countries country ) {
		if(countriesRepo.existsById(country.getCountry_id())) {
			throw new AllReadyExistsException(null);
		}
		return countriesRepo.save(country);
	}

	@Override
	public Countries updateCountry(String countryId, Countries updatedCountry){
		if(!countriesRepo.existsById(countryId)) {
			throw new CountryNotFoundException(" ");
		}
		Countries existingCountry=countriesRepo.findById(countryId).get();
		existingCountry.setCountry_name(updatedCountry.getCountry_name());
		existingCountry.setRegions(updatedCountry.getRegions());
		return countriesRepo.save(existingCountry);
	}

	@Override
	public String deleteCountryById(String countryId) {
		if(!countriesRepo.existsById(countryId)) {
			throw new CountryNotFoundException(" ");
		}
		countriesRepo.deleteById(countryId);
		return " Country Deleted Succefully";
	}

	@Override
	public Countries searchCountryById(String countryId) {
		if(!countriesRepo.existsById(countryId)) {
			throw new CountryNotFoundException(" ");
		}
		return countriesRepo.findById(countryId).get();
	}

	@Override
	public List<Countries> getAllCountries() {
		return countriesRepo.findAll();
	}
	
}
