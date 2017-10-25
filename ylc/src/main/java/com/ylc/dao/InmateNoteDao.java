package com.ylc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ylc.domain.InmateNote;
@Repository
public class InmateNoteDao {
	
	@Autowired
    SessionFactory sessionFactory;
	

	public void saveInmateNote(InmateNote inmateNote){		
		sessionFactory.getCurrentSession().saveOrUpdate(inmateNote);		
	}

}
