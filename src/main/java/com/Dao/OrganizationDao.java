package com.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.Models.Organization;

@Repository
public class OrganizationDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public int saveOrg(Organization org) {
		return (Integer) this.hibernateTemplate.save(org);
	}

	public boolean checkUsernameExists(String username) {
		String query = "from Organization where organizationName=:u";
		SessionFactory factory = hibernateTemplate.getSessionFactory();
		Session session = factory.openSession();
		Query q = session.createQuery(query);
		q.setParameter("u", username);
		try {
			q.getSingleResult();
			System.out.println("true");
			return true;
		} catch (Exception e) {
			System.out.println("false");
			return false;
		}
	}

	public boolean authUsernamePassword(String username, String password) {
		String query = "from Organization where organizationName=:u and password=:p";
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
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Failed to execute");
			return false;
		}
	}
}
