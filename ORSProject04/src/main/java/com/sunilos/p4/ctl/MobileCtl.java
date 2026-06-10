package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.MobileBean;
import com.sunilos.p4.model.MobileModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/MobileCtl")
public class MobileCtl extends BaseCtl<MobileBean, MobileModel> {
	
	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("code"))) {
			request.setAttribute("code", PropertyReader.getValue("error.require", "Code"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("mobileNumber"))) {
			request.setAttribute("mobileNumber", PropertyReader.getValue("error.require", "Mobile Number"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("otp"))) {
			request.setAttribute("otp", PropertyReader.getValue("error.require", "OTP"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "Status"));
			pass = false;
		}

		return pass;
	}

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
		return ORSView.MOBILE_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.MOBILE_CTL;
		}
		return ORSView.MOBILE_VIEW;
	}
	

	@Override
	protected MobileModel getModel() {
		return new MobileModel();
	}
	
	

}
