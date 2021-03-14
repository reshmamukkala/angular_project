package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ts.db.HibernateTemplate;
import com.dto.UserDetails;

public class UserDAO {
	private SessionFactory factory = null;
	
	public UserDetails loginUser(String loginId,String password) {

		return (UserDetails)HibernateTemplate.getObjectByUserPass(loginId,password);
	}
	
	public int register(UserDetails user) {
		System.out.println(user); 
		return HibernateTemplate.addObject(user);
	}
	
	public List<UserDetails> getAllUsers() {
		List<UserDetails> users = (List)HibernateTemplate.getObjectListByQuery("From User");
		System.out.println("Inside All Users ..."+users);
		return users;
	}

	public UserDetails getUser(int id) {
		return (UserDetails)HibernateTemplate.getObject(UserDetails.class,id);
	}
	public int update(UserDetails editUser) {
		System.out.println(editUser); 
		return HibernateTemplate.updateObject(editUser);
	}
	
	

	
}