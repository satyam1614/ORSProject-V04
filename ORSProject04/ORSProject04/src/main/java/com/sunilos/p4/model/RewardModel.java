package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.ATMSystemBean;
import com.sunilos.p4.bean.BaseBean;
import com.sunilos.p4.bean.MobileBean;
import com.sunilos.p4.bean.RewardBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class RewardModel  extends BaseModel<RewardBean>{

	@Override
	public long add(RewardBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;
		
		RewardBean existbean = findByCitizenName(bean.getCitizenName());
		
		if(existbean != null) {
			throw new DuplicateRecordException("citizenName already exists");
		}
		
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getCitizenName());
			pstmt.setString(3, bean.getPointsEarned());
			pstmt.setString(4, bean.getStatus());
			pstmt.setString(5, bean.getType());
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
	public void update(RewardBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model update Started");
		Connection conn = null;

		RewardBean beanExist = findByCitizenName(bean.getCitizenName());
		// Check if updated LoginId already exist
		if (beanExist != null && !(beanExist.getId() == bean.getId())) {
			throw new DuplicateRecordException("citizenName is already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE " + getTable() + " CITIZEN_NAME=?,POINTS_EARNED=?,STATUS=?,TYPE=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");
			pstmt.setString(1, bean.getCitizenName());
			pstmt.setString(2, bean.getPointsEarned());
			pstmt.setString(3, bean.getStatus());
			pstmt.setString(4, bean.getType());
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
	public String getWhereClause(RewardBean bean) {
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getCitizenName() != null && bean.getCitizenName().length() > 0) {
				sql.append(" AND CITIZEN_NAME like '" + bean.getCitizenName() + "%'");
			}
		}

		return sql.toString();
	}

	public RewardBean findByCitizenName(String citizenName) {
		return findByUniqueColumn("CITIZEN_NAME", citizenName);
	}

	@Override
	public String getTable() {
		return "st_reward";
	}

	@Override
	public RewardBean getBean() {
		return new RewardBean();
	}
	
}