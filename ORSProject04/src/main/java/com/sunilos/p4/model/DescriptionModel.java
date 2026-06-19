package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.DescriptionBean;
import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class DescriptionModel extends BaseModel<DescriptionBean>{

	@Override
	public long add(DescriptionBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0; 
		
		DescriptionBean existbean = findByModuleName(bean.getModuleName());
		
		if (existbean != null) {
			throw new DuplicateRecordException("Developer Name already exists");
		}
		
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			System.out.println(pk +" in ModelJDBC");
			 conn.setAutoCommit(false);
			 PreparedStatement pstmt = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?)");
			 pstmt.setInt(1, pk);
			 pstmt.setString(2, bean.getModuleName());
			 pstmt.setString(3, bean.getTechnology());
			 pstmt.setString(4, bean.getDeveloperName());
			 pstmt.setString(5, bean.getDeveloperName());
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
	public void update(DescriptionBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model update Started");
		Connection conn = null;

		DescriptionBean beanExist = findByModuleName(bean.getModuleName());
		
		if (beanExist != null && !(beanExist.getId() == bean.getId())) {
			throw new DuplicateRecordException("Developer Name is already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); 
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set module_name=?,technology=?,developer_name=?,status=?,created_by=?,modified_by=?,created_datetime=?,modified_datetime=? where id=?");
			pstmt.setString(1, bean.getModuleName());
			pstmt.setString(2, bean.getTechnology());
			pstmt.setString(3, bean.getDeveloperName());
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
	public String getWhereClause(DescriptionBean bean) {
		
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getModuleName() != null && bean.getModuleName().length() > 0) {
				sql.append(" AND module_name like '" + bean.getModuleName() + "%'");
			}
		}

		return sql.toString();
	}
	
	public DescriptionBean findByModuleName(String moduleName) {
		return findByUniqueColumn("module_name", moduleName);
	}

	@Override
	public String getTable() {
		return "st_description";
	}

	@Override
	public DescriptionBean getBean() {
		return new DescriptionBean();
	}

}
