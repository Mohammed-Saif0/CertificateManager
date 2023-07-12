package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.CertificateDao;
import com.Models.Certificate;

@Service
public class CertificateService {
	@Autowired
	private CertificateDao certificateDao;
	
	public int create(Certificate certificate) {
		return this.certificateDao.save(certificate);
	}
	
	public boolean check(String certificateName) {
		return this.certificateDao.checkCertificateName(certificateName);
	}
}
