package com.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Models.Certificate;

@Repository
public class CertificateDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional 	
	public int save(Certificate certificate) {
		return (Integer) this.hibernateTemplate.save(certificate);
	}

	public boolean checkCertificateName(String name) {
		String query = "from Certificate where certificateName=:name";
		SessionFactory factory = hibernateTemplate.getSessionFactory();
		Session session = factory.openSession();
		Query q = session.createQuery(query);
		q.setParameter("name",name);
		try {
			q.getSingleResult();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public List<Certificate> getUserCertificate(String username){
		SessionFactory factory = hibernateTemplate.getSessionFactory();
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(Certificate.class);
		System.out.println(username);
		cr.add(Restrictions.eq("user.userName",username));
		List<Certificate> certificate = cr.list();
		System.out.println("here in get certi");
		System.out.println(certificate);
		return certificate;
	}
}
