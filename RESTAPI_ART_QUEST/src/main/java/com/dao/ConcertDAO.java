package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.dto.ConcertDetails;
import com.ts.db.HibernateTemplate;

public class ConcertDAO {
	private SessionFactory factory = null;
		
		public List<ConcertDetails> getAllConcertDetails() {
			List<ConcertDetails> concertDetails=(List)HibernateTemplate.getObjectListByQuery("From ConcertDetails");
			return concertDetails;	
		}
		public int addconcert(ConcertDetails concert){
			System.out.println(concert);
			return HibernateTemplate.addObject(concert);
		}
	}