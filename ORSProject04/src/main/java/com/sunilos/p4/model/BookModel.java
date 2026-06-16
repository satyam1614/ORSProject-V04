package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.BookBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class BookModel  extends BaseModel<BookBean> {

	@Override
	public long add(BookBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;
		
		BookBean existbean = findByAuthor(bean.getAuthor());
		
		if(existbean != null) {
			throw new DuplicateRecordException("author already exists");
		}
		
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getAuthor());
			pstmt.setInt(4, bean.getPrice());
			pstmt.setString(5, bean.getPublisher());
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
	public void update(BookBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model update Started");
		Connection conn = null;
		

		BookBean beanExist = findByAuthor(bean.getAuthor());
		// Check if updated LoginId already exist
		if (beanExist != null && !(beanExist.getId() == bean.getId())) {
			throw new DuplicateRecordException("Author is already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement(
					"update " + getTable() + " set title=?,author=?,price=?,publisher=?,created_by=?,modified_by=?,created_datetime=?,modified_datetime=? where id=?");
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getAuthor());
			pstmt.setInt(3, bean.getPrice());
			pstmt.setString(4, bean.getPublisher());
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
	public String getWhereClause(BookBean bean) {
		
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getAuthor() != null && bean.getAuthor().length() > 0) {
				sql.append(" AND Author like '" + bean.getAuthor() + "%'");
			}
		}

		return sql.toString();
	}

	public BookBean findByAuthor(String author) {
		return findByUniqueColumn("author", author);
	}

	@Override
	public String getTable() {
		return "st_book";
	}

	@Override
	public BookBean getBean() {
		return new BookBean();
	}

}
