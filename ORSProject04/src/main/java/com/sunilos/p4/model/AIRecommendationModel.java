package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.AIRecommendationBean;
import com.sunilos.p4.bean.DescriptionBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class AIRecommendationModel extends BaseModel<AIRecommendationBean> {

	@Override
	public long add(AIRecommendationBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0; 
		
		AIRecommendationBean existbean = findByUserName(bean.getUserName());
		
		if (existbean != null) {
			throw new DuplicateRecordException("AIRecommendation Name already exists");
		}
		
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			System.out.println(pk +" in ModelJDBC");
			 conn.setAutoCommit(false);
			 PreparedStatement pstmt = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?)");
			 pstmt.setInt(1, pk);
			 pstmt.setString(2, bean.getCode());
			 pstmt.setString(3, bean.getUserName());
			 pstmt.setString(4, bean.getType());
			 pstmt.setString(5, bean.getStatus());
			 pstmt.setString(6, bean.getCreatedBy());
			 pstmt.setString(7, bean.getModifiedBy());
			 pstmt.setTimestamp(8, bean.getCreatedDatetime());
			 pstmt.setTimestamp(9, bean.getModifiedDatetime());
			 pstmt.executeUpdate();
			 conn.commit();
			 pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..",e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add User");
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model add End");
		return pk;
	}

	@Override
	public void update(AIRecommendationBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model update Started");
		Connection conn = null;

		AIRecommendationBean beanExist = findByUserName(bean.getUserName());
		
		if (beanExist != null && !(beanExist.getId() == bean.getId())) {
			throw new DuplicateRecordException("User Name is already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); 
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set code=?,user_name=?,type=?,status=?,created_by=?,modified_by=?,created_datetime=?,modified_datetime=? where id=?");
			pstmt.setString(1, bean.getCode());
			pstmt.setString(2, bean.getUserName());
			pstmt.setString(3, bean.getType());
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
	public String getWhereClause(AIRecommendationBean bean) {
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getUserName() != null && bean.getUserName().length() > 0) {
				sql.append(" AND user_name like '" + bean.getUserName() + "%'");
			}
		}

		return sql.toString();
	}
	
	public AIRecommendationBean findByUserName(String userName) {
		return findByUniqueColumn("user_name", userName);
	}
	

	@Override
	public String getTable() {
		return "st_ai_recommendation";
	}

	@Override
	public AIRecommendationBean getBean() {
		return new AIRecommendationBean();
	}

	

}
