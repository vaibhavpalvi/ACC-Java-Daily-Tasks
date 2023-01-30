package com.acc.example.V1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DataModel {
	
	@Id
	private int bid;
	private String bookname;
	private String authorname;
	private int price;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "DataModel [bid=" + bid + ", bookname=" + bookname + ", authorname=" + authorname + ", price=" + price
				+ "]";
	}
	
	

}
