package com.library.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.entity.Book;
import com.library.entity.User;
@Repository
public class BookDAOImp implements BookDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public void insertBook(Book book) {
		sessionFactory.getCurrentSession().save(book);
		
	}

	@Transactional
	@Override
	public void deleteBook(Book book) {
		sessionFactory.getCurrentSession().delete(book);
		
	}
	@Transactional
	@Override
	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
		
	}

	@Transactional
	@Override
	public List<Book> getAllBook() {
		List<Book> list = sessionFactory.getCurrentSession().createQuery("FROM book").list();
		return list;
	}

	@Transactional
	@Override
	public Book getBookByID(int bookID) {
		
		return (Book) sessionFactory.getCurrentSession().get(Book.class, bookID);
	}

	@Override
	public Book getBookByName(String bookName) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM book where name=:name");
		query.setString("name", bookName);
		return (Book) query.uniqueResult();
	}
	@Transactional
	@Override
	public Book findBook(int bookID) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("FROM book WHERE id=:id");
		query.setInteger("id", bookID);
		return (Book) query.uniqueResult();
		
	}

}
