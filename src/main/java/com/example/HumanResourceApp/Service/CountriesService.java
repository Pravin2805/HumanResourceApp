package com.example.HumanResourceApp.Service;

import java.util.List;

import com.example.HumanResourceApp.Entity.Countries;

public interface CountriesService {

	public Countries addNewCountry(Countries country);
	public Countries updateCountry(String countryId, Countries updatedCountry);
	public String deleteCountryById(String countryId);
	public Countries searchCountryById(String countryId);
	public List<Countries> getAllCountries();
	
}
