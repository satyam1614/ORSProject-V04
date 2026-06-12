package com.sunilos.p4.model.test;

import java.sql.Timestamp;
import java.util.Date;

import com.sunilos.p4.bean.CollegeBean;
import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.model.ProductModel;
import com.sunilos.p4.util.DataUtility;

public class TestProductModel {
	
	public static void main(String[] args) {
		
	   // testadd();
	    
	    
		
	}

	

	private static void testadd() {
		
		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();
		
		bean.setProductName("satyam");
		bean.setProductCategory("yadav");
		bean.setOrderDate(DataUtility.getDate("03/04/2004"));
		bean.setPrice(500);
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
		
	}
	
	
	

}
