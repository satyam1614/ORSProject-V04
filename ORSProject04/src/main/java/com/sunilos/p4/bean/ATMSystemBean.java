package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ATMSystemBean extends BaseBean {
	
	private String bankName;
	private String location;
	private String cashAvailable;
	private int securityCode;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCashAvailable() {
		return cashAvailable;
	}

	public void setCashAvailable(String cashAvailable) {
		this.cashAvailable = cashAvailable;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return bankName;
	}
	
	
@Override
public void setResultset(ResultSet rs) {
	
	try {
		super.setResultset(rs);
		this.setBankName(rs.getString("BANK_NAME"));
		this.setLocation(rs.getString("LOCATION"));
		this.setCashAvailable(rs.getString("CASH_AVAILABLE"));
		this.setSecurityCode(rs.getInt("SECURITY_CODE"));
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

}
