package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.dto.TutorDetails;
import com.ts.db.HibernateTemplate;

public class TutorDAO {

private SessionFactory factory = null;
public List<TutorDetails> getAlltutors() {
	List<TutorDetails> tutors=(List)HibernateTemplate.getObjectListByQuery("From TutorDetails");
	System.out.println("Inside All tutors ..."+tutors);
	return tutors;
}

public int addTutors(TutorDetails t){
	return HibernateTemplate.addObject(t);
	}

public List<TutorDetails> getTutorsByRole(String role) {
	List<TutorDetails> tutors =HibernateTemplate.getObjectByRole(role);
	
	
	System.out.println("Inside All handymans ..."+tutors);
	return tutors;
}
	
	public TutorDetails loginTutor(String loginId,String password) {

		return (TutorDetails)HibernateTemplate.getObjectByTutorPass(loginId,password);
	}
	
	public int register(TutorDetails tutor) {
		System.out.println(tutor); 
		return HibernateTemplate.addObject(tutor);
	}
	
	public List<TutorDetails> getAllTutors() {
		List<TutorDetails> tutors = (List)HibernateTemplate.getObjectListByQuery("From TutorDetails");
		System.out.println("Inside All Tutors ..."+tutors);
		return tutors;
	}

	public TutorDetails getTutor(int id) {
		return (TutorDetails)HibernateTemplate.getObject(TutorDetails.class,id);
	}
	public List<TutorDetails> getHandymanByRole(String artform) {
		List<TutorDetails> tutors =HibernateTemplate.getObjectByRole(artform);
		
		
		System.out.println("Inside All tutors ..."+tutors);
		return tutors;
	}


	

}