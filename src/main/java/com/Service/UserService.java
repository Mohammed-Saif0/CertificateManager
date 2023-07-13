package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.UserDao;
import com.Models.User;

@Service
public class UserService {
	@Autowired
	private UserDao userdao;
	
	public String createUser(User user) {
		return this.userdao.saveUser(user);
	}
	
	public boolean check(String username) {
		return this.userdao.checkUsernameExists(username);
	}
	
	public boolean auth(String username, String password) {
		return this.userdao.authUsernamePassword(username, password);
	}
	
	public User get(String username) {
		return this.userdao.getUser(username);
	}
}
