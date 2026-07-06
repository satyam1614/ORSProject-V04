package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LabTestBean extends BaseBean {
	
	private String name;
	private int cost;
	private Date testDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stu
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setName(rs.getString("name"));
			this.setCost(rs.getInt("cost"));
			this.setTestDate(rs.getDate("test_date"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
