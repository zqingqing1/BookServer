package com.bookme.bookme.dao;

import com.bookme.bookme.DataStore;
import com.bookme.bookme.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}

}
