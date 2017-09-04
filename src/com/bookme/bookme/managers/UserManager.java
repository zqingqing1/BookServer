package com.bookme.bookme.managers;

import com.bookme.bookme.dao.UserDao;
import com.bookme.bookme.entities.User;

public class UserManager {
	
	private static UserManager instance = new UserManager();
	private static UserDao dao = new UserDao();
	
	private UserManager() {    // private constructor

	}

	public static UserManager getInstance() {
		return instance;
	}

	public User createUser(long id, String email, String password, String firstName, String lastName, int gender,
			String userType) {
		User user=new User();
		user.setId(id);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setGender(gender);
		user.setUserType(userType);
		
		return user;
	}
	
	public User[] getUsers(){
		return dao.getUsers();
	}
}
