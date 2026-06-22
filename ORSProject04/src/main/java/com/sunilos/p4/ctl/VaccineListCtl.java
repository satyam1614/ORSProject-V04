package com.sunilos.p4.ctl;


import com.sunilos.p4.bean.VaccineBean;
import com.sunilos.p4.model.VaccineModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/VaccineListCtl")
public class VaccineListCtl extends BaseListCtl<VaccineBean, VaccineModel> {
	
	@Override
	protected VaccineBean populateBean(HttpServletRequest request) {
		
		VaccineBean bean = new VaccineBean();
		
		bean.setVaccineName(DataUtility.getString(request.getParameter("vaccineName")));
		bean.setManufacturer(DataUtility.getString(request.getParameter("manufacturer")));
		bean.setExpiryDate(DataUtility.getDate(request.getParameter("expiryDate")));
		
		
		populateDTO(bean, request);
		
		return bean;
	}
	

	@Override
	protected String getView() {
		return getView();
	}

	@Override
	protected String getView(String op) {
			return ORSView.VACCINE_LIST_VIEW;
	}

	@Override
	protected VaccineModel getModel() {
		return new VaccineModel();
	}

}
