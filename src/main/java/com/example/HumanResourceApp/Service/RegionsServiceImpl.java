package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HumanResourceApp.Entity.Regions;
import com.example.HumanResourceApp.Exception.AllReadyExistsException;
import com.example.HumanResourceApp.Exception.RegionNotFoundException;
import com.example.HumanResourceApp.Repository.RegionsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionsServiceImpl implements RegionsService{
	
	@Autowired
	RegionsRepository regionsRepo;

	@Override
	public List<Regions> getAllRegions() {
		return regionsRepo.findAll();
	}

	@Override
	public Regions addNewRegion(Regions region) {
		if(regionsRepo.existsById(region.getRegion_id())) {
			throw new AllReadyExistsException(null);
		}
		return regionsRepo.save(region);
	}

	@Override
	public Regions updateRegion(BigDecimal regionId, Regions updatedRegion) {
		if(!regionsRepo.existsById(regionId)) {
			throw new RegionNotFoundException("");
		}
		Regions existingRegion=regionsRepo.findById(regionId).get();
		existingRegion.setRegion_name(updatedRegion.getRegion_name());
		return regionsRepo.save(existingRegion);
	}

	@Override
	public String deleteRegionById(BigDecimal regionId) {
		if(!regionsRepo.existsById(regionId)) {
			throw new RegionNotFoundException("");
		}
		regionsRepo.deleteById(regionId);
		return "Region Succefully Deleted";
	}

	@Override
	public Regions searchRegionById(BigDecimal regionId) {
		if(!regionsRepo.existsById(regionId)) {
			throw new RegionNotFoundException("");
		}
		return regionsRepo.findById(regionId).get();
	}
	
	
}
