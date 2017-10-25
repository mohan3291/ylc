package com.ylc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.InmateReferralDao;
import com.ylc.domain.InMate;
import com.ylc.domain.InmateReferral;
@Service
public class InmateReferralService {
	
	@Autowired
	InmateReferralDao inmateReferralDao;
	
	
	public void saveInmateNote(com.ylc.model.InmateReferral inmateReferral){	
		InmateReferral inmateReferralD=new InmateReferral();
		copyModelToDomain(inmateReferral,inmateReferralD);		
		inmateReferralDao.saveInmateReferral(inmateReferralD);	
	}
	
	private void copyModelToDomain(com.ylc.model.InmateReferral inmateReferral,InmateReferral inmateReferralD) {
		InMate inMate=new InMate();
		inMate.setInmateID(inmateReferral.getInMate().getInmateID());		
		inmateReferralD.setInMate(inMate);
		InMate inMater=new InMate();
		inMater.setInmateID(inmateReferral.getInMateReferredBy().getInmateID());		
		inmateReferralD.setInMateReferredBy(inMater);	
	}
	

}
