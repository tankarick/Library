package com.library.dao;

import java.util.List;

import com.library.entity.User;

public interface UserDAO {
	
	public void addUser(User user);
	public User getUserByName(String userName);
	public void deleteUser(User user);
	public void updateUser(User user);
	public List<User> getAllUser();
	public User findUser(int id);
	public User getUserName(String userName, String password);
	public User getRole(String userName);
}
