package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileBean extends BaseBean {
	
	private String code;
	private String mobileNumber;
	private String otp;
	private String status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return code;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setCode(rs.getString("CODE"));
			this.setMobileNumber(rs.getString("MOBILE_NUMBER"));
			this.setOtp(rs.getString("OTP"));
			this.setStatus(rs.getString("STATUS"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	

}
