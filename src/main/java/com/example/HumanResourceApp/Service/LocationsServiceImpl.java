package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HumanResourceApp.Entity.Locations;
import com.example.HumanResourceApp.Exception.AllReadyExistsException;
import com.example.HumanResourceApp.Exception.LocationNotFoundException;
import com.example.HumanResourceApp.Repository.LocationsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LocationsServiceImpl implements LocationsService {

	@Autowired
	LocationsRepository locationsRepo;

	@Override
	public Locations addNewLocation(Locations location) {
		if(locationsRepo.existsById(location.getLocation_id())) {
			throw new AllReadyExistsException(null);
		}
		return locationsRepo.save(location);
	}

	@Override
	public Locations updateLocation(BigDecimal locationId, Locations updatedLocation) {
		if (!locationsRepo.existsById(locationId)) {
			throw new LocationNotFoundException("");
		}
		Locations existingLocation=locationsRepo.findById(locationId).get();
		existingLocation.setStreet_address(updatedLocation.getStreet_address());
		existingLocation.setPostal_code(updatedLocation.getPostal_code());
		existingLocation.setCity(updatedLocation.getCity());
		existingLocation.setState_province(updatedLocation.getState_province());
		existingLocation.setCountries(updatedLocation.getCountries());
		return locationsRepo.save(existingLocation);
	}

	@Override
	public String deleteLocationById(BigDecimal locationId) {
		if (!locationsRepo.existsById(locationId)) {
			throw new LocationNotFoundException("");
		}
		Locations location=locationsRepo.findById(locationId).get();
		location.setCountries(null);
		locationsRepo.deleteById(locationId);
		return "Location Deleted Succefully";
	}

	@Override
	public Locations searchLocationById(BigDecimal locationId) {
		if (!locationsRepo.existsById(locationId)) {
			throw new LocationNotFoundException("");
		}
		return locationsRepo.findById(locationId).get();
	}

	@Override
	public List<Locations> getAllLocations() {
		return locationsRepo.findAll();
	}
}
