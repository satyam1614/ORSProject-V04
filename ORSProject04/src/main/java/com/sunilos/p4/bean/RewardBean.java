package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RewardBean extends BaseBean {
	
	private String citizenName;
	private String pointsEarned;
	private String status;
	private String type;
	

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getPointsEarned() {
		return pointsEarned;
	}

	public void setPointsEarned(String pointsEarned) {
		this.pointsEarned = pointsEarned;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return citizenName;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setCitizenName(rs.getString("CITIZEN_NAME"));
			this.setPointsEarned(rs.getString("POINTS_EARNED"));
			this.setStatus(rs.getString("STATUS"));
			this.setType(rs.getString("TYPE"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
