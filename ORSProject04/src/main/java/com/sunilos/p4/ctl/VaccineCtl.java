package com.sunilos.p4.ctl;


import com.sunilos.p4.bean.VaccineBean;
import com.sunilos.p4.model.VaccineModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/VaccineCtl")
public class VaccineCtl extends BaseCtl<VaccineBean, VaccineModel> {
	
	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("vaccineName"))) {
			request.setAttribute("vaccineName", PropertyReader.getValue("error.require", "VaccineName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("manufacturer"))) {
			request.setAttribute("manufacturer", PropertyReader.getValue("error.require", "Manufacturer"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("expiryDate"))) {
			request.setAttribute("expiryDate", PropertyReader.getValue("error.require", "ExpiryDate"));
			pass = false;
		}


		return pass;
	}

	@Override
	protected VaccineBean populateBean(HttpServletRequest request) {

		VaccineBean bean = new VaccineBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setVaccineName(DataUtility.getString(request.getParameter("vaccineName")));
		bean.setManufacturer(DataUtility.getString(request.getParameter("manufacturer")));
		bean.setExpiryDate(DataUtility.getDate(request.getParameter("expiryDate")));
		

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.VACCINE_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.VACCINE_LIST_CTL;
		}
		return ORSView.VACCINE_VIEW;
	}


	@Override
	protected VaccineModel getModel() {
		return new VaccineModel();
	}

}
