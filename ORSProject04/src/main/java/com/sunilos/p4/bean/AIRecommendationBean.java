package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AIRecommendationBean extends BaseBean{
	
	private String code;
	private String userName;
	private String type;
	private String status;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
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
		this.setCode(rs.getString("code"));
		this.setUserName(rs.getString("user_name"));
		this.setType(rs.getString("type"));
		this.setStatus(rs.getString("status"));
	}catch (SQLException e) {
		e.printStackTrace();
	}

	}

}
