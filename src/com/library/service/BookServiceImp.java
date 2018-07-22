package com.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.BookDAO;
import com.library.entity.Book;
import com.library.entity.User;
@Service
public class BookServiceImp implements BookService{
	
	@Autowired
	BookDAO bookDAO;
	
	@Transactional
	@Override
	public void insertBook(Book book) {
		bookDAO.insertBook(book);
		
	}

	@Transactional
	@Override
	public void deleteBook(Book book) {
		bookDAO.deleteBook(book);
		
	}

	@Override
	public void updateBook(Book book) {
		bookDAO.updateBook(book);
		
	}

	@Transactional
	@Override
	public List<Book> getAllBook() {
		
		return bookDAO.getAllBook();
	}

	@Transactional
	@Override
	public Book getBookByID(int bookID) {
		
		return bookDAO.getBookByID(bookID);
	}

	@Override
	public Book getBookByName(String bookName) {
		
		return bookDAO.getBookByName(bookName);
	}
	@Override
	public Book findBook(int bookID) {
		return bookDAO.findBook(bookID);
		
	}

}
