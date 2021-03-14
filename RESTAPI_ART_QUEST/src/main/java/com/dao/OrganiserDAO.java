package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.dto.OrganiserDetails;
import com.dto.TutorDetails;
import com.ts.db.HibernateTemplate;

public class OrganiserDAO {
private SessionFactory factory = null;
	
	public OrganiserDetails getOrganiserByOrganiserPass(String loginId,String password) {

		return (OrganiserDetails)HibernateTemplate.getObjectByUserPass(loginId,password);
	}
	
	public int register(OrganiserDetails organiser) {
		System.out.println(organiser); 
		return HibernateTemplate.addObject(organiser);
	}
	
	public List<OrganiserDetails> getAllOrganisers() {
		List<OrganiserDetails> organisers = (List)HibernateTemplate.getObjectListByQuery("From Organiser");
		System.out.println("Inside All Organisers ..."+organisers);
		return organisers;
	}
	public List<OrganiserDetails> getOrganiserByRole(String tutorMail) {
		List<OrganiserDetails> organisers =HibernateTemplate.getObjectBySubject(tutorMail);
		
		
		System.out.println("Inside All handymans ..."+organisers);
		return organisers;
	}
	public OrganiserDetails getOrganiser(int id) {
		return (OrganiserDetails)HibernateTemplate.getObject(OrganiserDetails.class,id);
	}

	

	
}