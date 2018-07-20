package com.library.service;

import java.util.List;

import com.library.entity.User;

public interface UserService {

	public void addUser(User user);
	public User getUserByName(String userName);
	public void deleteUser(User user);
	public void updateUser(User user);
	public List<User> getAllUser();
	public User getUserName(String userName, String password);
	public User findUser(int id);
}
