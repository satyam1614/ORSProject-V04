package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookBean  extends BaseBean {
	
	private String title;
	private String author;
	private int price;
	private String publisher;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return author;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setTitle(rs.getString("title"));
			this.setAuthor(rs.getString("author"));
			this.setPrice(rs.getInt("price"));
			this.setPublisher(rs.getString("publisher"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
