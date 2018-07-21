package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.dao.UserDAO;
import com.library.entity.User;
@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserDAO userDao;
	
	@Transactional
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public User getUserByName(String userName) {
		
		return userDao.getUserByName(userName);
	}
	@Transactional
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userDao.deleteUser(user);
	}
	@Transactional
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);		
	}
	@Transactional
	@Override
	public List<User> getAllUser() {
		
		return userDao.getAllUser();
	}

	@Override
	public User getUserName(String userName, String password) {
		return userDao.getUserName(userName, password);
		
	}
	@Override
	public User findUser(int id) {
		return userDao.findUser(id);
		
	}
	
	@Transactional
	@Override
	public User getRole(String userName) {
		// TODO Auto-generated method stub
		return userDao.getRole(userName);
	}

}
