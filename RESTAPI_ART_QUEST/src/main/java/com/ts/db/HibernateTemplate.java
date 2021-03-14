package com.ts.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.dto.UserDetails;
import com.dto.TutorDetails;
import com.dto.OrganiserDetails;


public class HibernateTemplate {

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj)
	{
		System.out.println("Inside Template...");
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		
		try {			
			return sessionFactory.openSession().get(c,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static Object getObjectByUserPass(String email,String password) {
	
	String queryString = "from UserDetails where email = :email and password =:password";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setString("email", email);
	  query.setString("password", password);
	  Object queryResult = query.uniqueResult();
	  UserDetails user = (UserDetails)queryResult;
	  return user; 
	}
	public static Object getObjectByTutorPass(String email,String password) {
		
		String queryString = "from TutorDetails where email = :email and password =:password";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("email", email);
		  query.setString("password", password);
		  Object queryResult = query.uniqueResult();
		  TutorDetails tutor = (TutorDetails)queryResult;
		  return tutor; 
		}
	public static Object getObjectByEmail(String email) {
		
		String queryString = "from UserDetails where email = :email";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("email", email);
		  Object queryResult = query.uniqueResult();
		  UserDetails user = (UserDetails)queryResult;
		  return user;
		}
	
	public static List<Object> getObjectListByQuery(String query)
	{
		return sessionFactory.openSession().createQuery(query).list();
	}
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		
		return result;
	}

	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	}
	
	public static List<TutorDetails> getObjectByRole(String artform) {
		
		String queryString = "from TutorDetails where artform = :artform";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("artform", artform);
		  List<TutorDetails> li= query.list();
		  return li;
		}
public static List<OrganiserDetails> getObjectBySubject(String tutorMail) {
		
		String queryString = "from OrganiserDetails where tutorMail = :tutorMail";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("tutorMail", tutorMail);
		  List<OrganiserDetails> li= query.list();
		  return li;
		}
public static void delete(int organiserId){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    String sql = "delete FROM OrganiserDetails WHERE organiserId = :organiserId";
    Query query = session.createQuery(sql);
    query.setInteger("organiserId", organiserId);
     int row = query.executeUpdate();
     if (row == 0)
         System.out.println("Doesnt deleted any row!");
     else
         System.out.println("Deleted Row: "+ row);
    session.getTransaction().commit();
    session.close();
}
}