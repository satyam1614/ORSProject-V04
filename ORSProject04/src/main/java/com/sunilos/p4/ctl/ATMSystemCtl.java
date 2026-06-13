package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.ATMSystemBean;
import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.model.ATMSystemModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/ATMSystemCtl")
public class ATMSystemCtl extends BaseCtl<ATMSystemBean, ATMSystemModel> {
	
	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("bankName"))) {
			request.setAttribute("bankName", PropertyReader.getValue("error.require", "bankName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("location"))) {
			request.setAttribute("location", PropertyReader.getValue("error.require", "location"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("cashAvailable"))) {
			request.setAttribute("cashAvailable", PropertyReader.getValue("error.require", "cashAvailable"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("securityCode"))) {
			request.setAttribute("securityCode", PropertyReader.getValue("error.require", "securityCode"));
			pass = false;
		}else if (!DataValidator.isInteger(request.getParameter("securityCode"))) {
			request.setAttribute("securityCode", "Invalid Security Code");
			
		}

		return pass;
	}

	@Override
	protected ATMSystemBean populateBean(HttpServletRequest request) {

		ATMSystemBean bean = new ATMSystemBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
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
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.ATMSYSTEM_CTL;
		}
		return ORSView.ATMSYSTEM_VIEW;
	}
	

	@Override
	protected ATMSystemModel getModel() {
		return new ATMSystemModel();
	}
	
	

}
