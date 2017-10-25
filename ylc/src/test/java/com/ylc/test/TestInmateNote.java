package com.ylc.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylc.model.InMate;
import com.ylc.model.InmateNote;
import com.ylc.service.InmateNoteService;

public class TestInmateNote extends BaseTest{

	
	@Autowired
    private InmateNoteService inmateNoteService;
	
	@Ignore("Only one time insert")	
	@Test
	public void  insertInmateNote() {
		InmateNote inmateNote=new InmateNote();
		InMate inMate=new InMate();
		inMate.setInmateID(1);
		inmateNote.setInMate(inMate);
		inmateNote.setInmateNotes(inmateNote.getInmateNotes());
		inmateNoteService.saveInmateNote(inmateNote);
		
		
	}

}
