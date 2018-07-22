package com.library.dao;

import java.util.List;

import com.library.entity.Book;
import com.library.entity.User;

public interface BookDAO {
	
	public void insertBook(Book book);
	public void deleteBook(Book book);
	public void updateBook(Book book);
	public List<Book> getAllBook();
	public Book getBookByID(int bookID);
	public Book getBookByName(String bookName);
	public Book findBook(int bookID);
}
