package com.examplerest.service.impl;

import java.util.List;

import com.examplerest.service.model.User;

public interface UserService {

	boolean isUserExist(User user);

	void deleteAllUsers();

	List<User> findAllUsers();

	void deleteUserById(long id);

	void updateUser(User user);

	User findById(long id);

}
