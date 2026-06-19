package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DescriptionBean extends BaseBean {
	
	private String moduleName;
	private String technology;
	private String developerName;
	private String status;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setModuleName(rs.getString("module_name"));
			this.setTechnology(rs.getString("technology"));
			this.setDeveloperName(rs.getString("developer_name"));
			this.setStatus(rs.getString("status"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
