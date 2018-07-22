package com.library.service;

import java.util.List;

import com.library.entity.Book;
import com.library.entity.User;

public interface BookService {
	
	public void insertBook(Book book);
	public void deleteBook(Book book);
	public void updateBook(Book book);
	public List<Book> getAllBook();
	public Book getBookByID(int bookID);
	public Book getBookByName(String bookName);
	public Book findBook(int bookID);
}
