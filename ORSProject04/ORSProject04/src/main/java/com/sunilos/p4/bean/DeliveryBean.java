package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DeliveryBean extends BaseBean {
	
	private String deliveryBoyName;
	private String address;
	private Date deliveryDate;
	private String status;
	
	

	public String getDeliveryBoyName() {
		return deliveryBoyName;
	}

	public void setDeliveryBoyName(String deliveryBoyName) {
		this.deliveryBoyName = deliveryBoyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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
		return deliveryBoyName;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setDeliveryBoyName(rs.getString("delivery_boy_name"));
			this.setAddress(rs.getString("address"));
			this.setDeliveryDate(rs.getDate("delivery_date"));
			this.setStatus(rs.getString("status"));
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

}
