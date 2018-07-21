package com.library.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "user")
public class User implements Serializable{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ticketnumber")
	private int ticketNumber;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String passWord;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "quantitycanborrow")
	private int quantityOfBookCanBorrow;
	
	@Column(name = "canborrow")
	private int canBorrow;

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getQuantityOfBookCanBorrow() {
		return quantityOfBookCanBorrow;
	}

	public void setQuantityOfBookCanBorrow(int quantityOfBookCanBorrow) {
		this.quantityOfBookCanBorrow = quantityOfBookCanBorrow;
	}

	public int getCanBorrow() {
		return canBorrow;
	}

	public void setCanBorrow(int canBorrow) {
		this.canBorrow = canBorrow;
	}
	
	

	
	
	
}
