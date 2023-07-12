package com.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.Models.Certificate;

@Repository
public class CertificateDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

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
}
