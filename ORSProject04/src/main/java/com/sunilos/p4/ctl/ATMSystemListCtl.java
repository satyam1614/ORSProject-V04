package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.ATMSystemBean;
import com.sunilos.p4.bean.DeliveryBean;
import com.sunilos.p4.model.ATMSystemModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/ATMSystemListCtl")
public class ATMSystemListCtl extends BaseListCtl<ATMSystemBean, ATMSystemModel>{
	
	@Override
	protected ATMSystemBean populateBean(HttpServletRequest request) {
		
	 ATMSystemBean bean = new ATMSystemBean();
		
		bean.setBankName(DataUtility.getString(request.getParameter("bankName")));
		bean.setLocation(DataUtility.getString(request.getParameter("location")));
		bean.setCashAvailable(DataUtility.getString(request.getParameter("cashAvailable")));
		bean.setSecurityCode(DataUtility.getInt(request.getParameter("securityCode")));
		
		populateDTO(bean, request);
		
		return bean;
	}


	@Override
	protected String getView() {
		return ORSView.ATMSYSTEM_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.ATMSYSTEM_LIST_VIEW;
	}

	@Override
	protected ATMSystemModel getModel() {
		return new ATMSystemModel();
	}

}
