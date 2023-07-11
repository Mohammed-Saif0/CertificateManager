package com.Dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.Models.User;

@Repository
public class UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveUser(User user) {
		return (Integer)this.hibernateTemplate.save(user);
	}
	
	public boolean checkUsernameExists(String username) {
		String query = "from User where userName=:u";
		SessionFactory factory = hibernateTemplate.getSessionFactory();
		Session session = factory.openSession();
		Query q =  session.createQuery(query);
		q.setParameter("u", username);
		try {
			q.getSingleResult();
			System.out.println("true");
			return true;
		}
		catch(Exception e) {
			System.out.println("false");
			return false;
		}
	}
	
	public boolean authUsernamePassword(String username, String password) {

		String query = "from User where userName=:u and password=:p";
		SessionFactory factory = hibernateTemplate.getSessionFactory();
		Session session = factory.openSession();
		Query q = session.createQuery(query);
		q.setParameter("u", username);
		q.setParameter("p", password);
		
		try {
			q.getFirstResult();
			System.out.println("successfully executed");
			System.out.println(username);
			System.out.println(password);
			return true;
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Failed to execute");
			return false;
		}
	}
}
