package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.jdbc.JdbcConnection;
import com.sunilos.p4.bean.ATMSystemBean;
import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class ATMSystemModel  extends BaseModel<ATMSystemBean> {

	@Override
	public long add(ATMSystemBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;
		
		ATMSystemBean existbean = findByBankName(bean.getBankName());
		
		if(existbean != null) {
			throw new DuplicateRecordException("bankName already exists");
		}
		
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getBankName());
			pstmt.setString(3, bean.getLocation());
			pstmt.setString(4, bean.getCashAvailable());
			pstmt.setInt(5, bean.getSecurityCode());
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
	public void update(ATMSystemBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model update Started");
		Connection conn = null;

		ATMSystemBean beanExist = findByBankName(bean.getBankName());
		// Check if updated LoginId already exist
		if (beanExist != null && !(beanExist.getId() == bean.getId())) {
			throw new DuplicateRecordException("ProductName is already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE " + getTable() + " SET BANK_NAME=?,LOCATION=?,CASH_AVAILABLE=?,SECURITY_CODE=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");
			pstmt.setString(1, bean.getBankName());
			pstmt.setString(2, bean.getLocation());
			pstmt.setString(3, bean.getCashAvailable());
			pstmt.setInt(4, bean.getSecurityCode());
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
			throw new ApplicationException("Exception in updating User ");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model update End");
	}


	@Override
	public String getWhereClause(ATMSystemBean bean) {
		
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getBankName() != null && bean.getBankName().length() > 0) {
				sql.append(" AND BANK_NAME like '" + bean.getBankName() + "%'");
			}
		}

		return sql.toString();
	}

	public ATMSystemBean findByBankName(String bankName) {
		return findByUniqueColumn("BANK_NAME", bankName);
	}

	@Override
	public String getTable() {
		return "st_atm";
	}

	@Override
	public ATMSystemBean getBean() {
		return new ATMSystemBean();
	}

}
