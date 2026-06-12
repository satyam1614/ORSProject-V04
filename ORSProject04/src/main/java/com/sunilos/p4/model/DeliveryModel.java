package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.DeliveryBean;
import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class DeliveryModel extends BaseModel<DeliveryBean> {

	@Override
	public long add(DeliveryBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;

		DeliveryBean existbean = findByDeliveryBoyName(bean.getDeliveryBoyName());

		if (existbean != null) {
			throw new DuplicateRecordException("product Name already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getDeliveryBoyName());
			pstmt.setString(3, bean.getAddress());
			pstmt.setDate(4, new java.sql.Date(bean.getDeliveryDate().getTime()));
			pstmt.setString(5, bean.getStatus());
			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(7, bean.getModifiedBy());
			pstmt.setTimestamp(8, bean.getCreatedDatetime());
			pstmt.setTimestamp(9, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model add End");
		return pk;
	}

	@Override
	public void update(DeliveryBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model update Started");
		Connection conn = null;

		DeliveryBean beanExist = findByDeliveryBoyName(bean.getDeliveryBoyName());
		// Check if updated LoginId already exist
		if (beanExist != null && !(beanExist.getId() == bean.getId())) {
			throw new DuplicateRecordException("Delivery Boy Name is already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("UPDATE " + getTable()
					+ " SET delivery_boy_name=?,address=?,delivery_date=?,status=?,created_by=?,modified_by=?,created_datetime=?,modified_datetime=? where id=?");
			pstmt.setString(1, bean.getDeliveryBoyName());
			pstmt.setString(2, bean.getAddress());
			pstmt.setDate(3, new java.sql.Date(bean.getDeliveryDate().getTime()));
			pstmt.setString(4, bean.getStatus());
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
			pstmt.setLong(9, bean.getId());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("Exception in updating User ");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model update End");
	}

	@Override
	public String getWhereClause(DeliveryBean bean) {

		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getDeliveryBoyName() != null && bean.getDeliveryBoyName().length() > 0) {
				sql.append(" AND DELIVERY_BOY_NAME like '" + bean.getDeliveryBoyName() + "%'");
			}
		}

		return sql.toString();
	}

	public DeliveryBean findByDeliveryBoyName(String deliveryBoyName) {
		return findByUniqueColumn("delivery_boy_name", deliveryBoyName);
	}

	@Override
	public DeliveryBean getBean() {
		return new DeliveryBean();
	}

	@Override
	public String getTable() {
		return "st_delivery";
	}

}
