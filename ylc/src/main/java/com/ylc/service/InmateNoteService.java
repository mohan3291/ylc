package com.ylc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.InmateNoteDao;
import com.ylc.domain.InMate;
import com.ylc.domain.InmateNote;
@Service
public class InmateNoteService {
	
	@Autowired
	InmateNoteDao inmateNoteDao;
	
	
	public void saveInmateNote(com.ylc.model.InmateNote inmateNote){	
		InmateNote inmateNoteD=new InmateNote();
		copyModelToDomain(inmateNote,inmateNoteD);		
		inmateNoteDao.saveInmateNote(inmateNoteD);	
	}
	
	private void copyModelToDomain(com.ylc.model.InmateNote inmateNote,InmateNote inmateNoteD) {
		InMate inMate=new InMate();
		inMate.setInmateID(inmateNote.getInMate().getInmateID());
		inmateNoteD.setInMate(inMate);
		inmateNoteD.setInmateNotes(inmateNote.getInmateNotes());
		
	}
	

}
