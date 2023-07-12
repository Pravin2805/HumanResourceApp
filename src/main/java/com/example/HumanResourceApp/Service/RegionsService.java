package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;
import java.util.List;

import com.example.HumanResourceApp.Entity.Regions;

public interface RegionsService {
	
	public Regions addNewRegion(Regions region);
	public Regions updateRegion(BigDecimal regionId, Regions updatedRegion);
	public String deleteRegionById(BigDecimal regionId);
	public Regions searchRegionById(BigDecimal regionId);
	public List<Regions> getAllRegions();
}
