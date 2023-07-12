package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;
import java.util.List;

import com.example.HumanResourceApp.Entity.Locations;

public interface LocationsService {

	public Locations addNewLocation(Locations location);
	public Locations updateLocation(BigDecimal locationId, Locations updatedLocation);
	public String deleteLocationById(BigDecimal locationId);
	public Locations searchLocationById(BigDecimal locationId);
	public List<Locations> getAllLocations();
}
