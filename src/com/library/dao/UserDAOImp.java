package com.library.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.entity.User;

@Repository
public class UserDAOImp implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);

	}
	@Transactional
	@Override
	public User getUserByName(String userName) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM user WHERE username=:name");
		query.setString("name", userName);
		return (User) query.uniqueResult();
	}
	@Transactional
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(user);
	}
	@Transactional
	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return (List<User>) sessionFactory.getCurrentSession().createQuery("from user").list();
	}
	@Transactional
	@Override
	//o day chi truyen vao duoc ID cua clas entity thôi. 
	public User getUserName(String userName, String passWord) {
		//Em dung cau lenh HQL o day. 
		// FROM Ủe ƯHEE userName = ? //// xem hql 
		Query query = sessionFactory.getCurrentSession().createQuery("FROM user WHERE username=:name and password=:pass");
		query.setString("name", userName);
		query.setString("pass", passWord);
		return (User) query.uniqueResult();

	}
	@Transactional
	@Override
	public User findUser(int id) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("FROM user WHERE id=:id");
		query.setInteger("id", id);
		return (User) query.uniqueResult();
		
	}
	@Transactional
	@Override
	public User getRole(String userName) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM user WHERE username=:name");
		query.setString("name", userName);
		return (User) query.uniqueResult();
	}

}
