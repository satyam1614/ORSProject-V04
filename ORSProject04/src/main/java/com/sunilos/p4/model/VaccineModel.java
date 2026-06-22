package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;


import com.sunilos.p4.bean.VaccineBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class VaccineModel extends BaseModel<VaccineBean> {

	@Override
	public long add(VaccineBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;

		VaccineBean existbean = findByVaccineName(bean.getVaccineName());

		if (existbean != null) {
			throw new DuplicateRecordException("Vaccine Name already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getVaccineName());
			pstmt.setString(3, bean.getManufacturer());
			pstmt.setDate(4, new java.sql.Date(bean.getExpiryDate().getTime()));
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
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
	public void update(VaccineBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model update Started");
		Connection conn = null;

		VaccineBean beanExist = findByVaccineName(bean.getVaccineName());
		// Check if updated LoginId already exist
		if (beanExist != null && !(beanExist.getId() == bean.getId())) {
			throw new DuplicateRecordException("Vaccine Name is already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set vaccine_name=?,manufacturer=?,expiry_date=?,created_by=?,modified_by=?,created_datetime=?,modified_datetime=? where id=?");
			pstmt.setString(1, bean.getVaccineName());
			pstmt.setString(2, bean.getManufacturer());
			pstmt.setDate(3, new java.sql.Date(bean.getExpiryDate().getTime()));
			pstmt.setString(4, bean.getCreatedBy());
			pstmt.setString(5, bean.getModifiedBy());
			pstmt.setTimestamp(6, bean.getCreatedDatetime());
			pstmt.setTimestamp(7, bean.getModifiedDatetime());
			pstmt.setLong(8, bean.getId());
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
	public String getWhereClause(VaccineBean bean) {
		
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getVaccineName() != null && bean.getVaccineName().length() > 0) {
				sql.append(" AND vaccine_name like '" + bean.getVaccineName() + "%'");
			}
		}

		return sql.toString();
	}

	public VaccineBean findByVaccineName(String vaccineName) {
		return findByUniqueColumn("vaccine_name", vaccineName);
	}

	@Override
	public String getTable() {
		return "st_vaccine";
	}

	@Override
	public VaccineBean getBean() {
		return new VaccineBean();
	}

}
