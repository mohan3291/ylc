package com.ylc.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.FacilityDao;
import com.ylc.domain.FacilityLocation;
import com.ylc.util.YlcUtils;

@Service
public class FacilityService {

	@Autowired
	FacilityDao facilityDao;

	public List<com.ylc.model.FacilityLocation> getFacilities()
			throws IllegalAccessException, InvocationTargetException,
			InstantiationException {
		List<FacilityLocation> facilityLocations = facilityDao.getFacilities();
		List<com.ylc.model.FacilityLocation> modelfacilities = new ArrayList<com.ylc.model.FacilityLocation>();
		for(FacilityLocation fl:facilityLocations)
			modelfacilities.add(YlcUtils.copy(fl));
		
		return modelfacilities;
	}
	public List<com.ylc.model.FacilityLocation> getFacilitiesByID(Integer facID)
			throws IllegalAccessException, InvocationTargetException,
			InstantiationException {
		List<FacilityLocation> facilityLocations = facilityDao.getFacilitiesByID(facID);
		List<com.ylc.model.FacilityLocation> modelfacilities = new ArrayList<com.ylc.model.FacilityLocation>();
		YlcUtils.copyProperties(modelfacilities, facilityLocations,
				com.ylc.model.FacilityLocation.class);
		return modelfacilities;
	}

	public void saveFacility(com.ylc.model.FacilityLocation modelFacility)
			throws IllegalAccessException, InvocationTargetException {
		FacilityLocation facilityLocation = new FacilityLocation();
		YlcUtils.copyProperties(facilityLocation, modelFacility);
		facilityDao.saveFacility(facilityLocation);
	}
}
