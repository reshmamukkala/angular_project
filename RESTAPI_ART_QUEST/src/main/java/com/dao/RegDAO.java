package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.dto.RegDetails;
import com.ts.db.HibernateTemplate;

public class RegDAO {
	private SessionFactory factory = null;
	
	public List<RegDetails> getAllItemDetails() {
		List<RegDetails> regDetails=(List)HibernateTemplate.getObjectListByQuery("From RegDetails");
		return regDetails;	
	}
}