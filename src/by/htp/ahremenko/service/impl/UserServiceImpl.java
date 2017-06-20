package by.htp.ahremenko.service.impl;

import by.htp.ahremenko.domain.User;
import by.htp.ahremenko.service.UserService;

public class UserServiceImpl implements UserService {

	public User Authorization(String login, String password) {
		User user = new User(login);
		user.setPassword("123");
		if ( user.getPassword().equals(password) ) {
			return user;
		}
		return null;
	}
	
	

}
