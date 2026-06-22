package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.MobileBean;
import com.sunilos.p4.model.MobileModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/MobileListCtl")
public class MobileListCtl extends BaseListCtl<MobileBean, MobileModel> {
	
	@Override
	protected MobileBean populateBean(HttpServletRequest request) {
		
		MobileBean bean = new MobileBean();
		
		bean.setCode(DataUtility.getString(request.getParameter("code")));
		bean.setMobileNumber(DataUtility.getString(request.getParameter("mobileNumber")));
		bean.setOtp(DataUtility.getString(request.getParameter("otp")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));
		
		populateDTO(bean, request);
		
		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.MOBILE_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.MOBILE_LIST_VIEW;
	}

	@Override
	protected MobileModel getModel() {
		return new MobileModel();
	}

}
