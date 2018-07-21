package com.library.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "booktotalstatus")
public class BookTotalStatus implements Serializable{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "bookid")
	private int bookID;
	
	@Column(name = "total")
	private int bookTotal;
	
	@Column(name = "remain")
	private int bookRemain;
	
	@Column(name = "borrowing")
	private int quantityOfBorrowing;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public int getBookTotal() {
		return bookTotal;
	}

	public void setBookTotal(int bookTotal) {
		this.bookTotal = bookTotal;
	}

	public int getBookRemain() {
		return bookRemain;
	}

	public void setBookRemain(int bookRemain) {
		this.bookRemain = bookRemain;
	}

	public int getQuantityOfBorrowing() {
		return quantityOfBorrowing;
	}

	public void setQuantityOfBorrowing(int quantityOfBorrowing) {
		this.quantityOfBorrowing = quantityOfBorrowing;
	}
	
	
}
