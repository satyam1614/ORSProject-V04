package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ReportBean  extends BaseBean {
	
	private String type;
	private Date generatedDate;
	private String remarks;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(Date generatedDate) {
		this.generatedDate = generatedDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
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
			this.setType(rs.getString("type"));
			this.setGeneratedDate(rs.getDate("generated_date"));
			this.setRemarks(rs.getString("remarks"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
