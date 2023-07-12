package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.OrganizationDao;
import com.Models.Organization;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationDao orgdao;
	@Transactional
	public int createOrg(Organization org) {
		return orgdao.saveOrg(org);
	}
	
	public boolean check(String orgName) {
		return this.orgdao.checkUsernameExists(orgName);
	}
	
	public boolean auth(String username,String password) {
		return this.orgdao.authUsernamePassword(username, password);
	}
}
