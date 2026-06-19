package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.DescriptionBean;
import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.model.DescriptionModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/DescriptionCtl")
public class DescriptionCtl extends BaseCtl<DescriptionBean, DescriptionModel> {
	
	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("moduleName"))) {
			request.setAttribute("moduleName", PropertyReader.getValue("error.require", "Module Name"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("technology"))) {
			request.setAttribute("technology", PropertyReader.getValue("error.require", "Technology"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("developerName"))) {
			request.setAttribute("developerName", PropertyReader.getValue("error.require", "Developer Name"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "Status"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected DescriptionBean populateBean(HttpServletRequest request) {

		DescriptionBean bean = new DescriptionBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setModuleName(DataUtility.getString(request.getParameter("moduleName")));
		bean.setTechnology(DataUtility.getString(request.getParameter("technology")));
		bean.setDeveloperName(DataUtility.getString(request.getParameter("developerName")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.DESCRIPTION_VIEW;
	}

	@Override
	protected String getView(String op) {
	if (OP_CANCEL.equalsIgnoreCase(op)) {
		return ORSView.DESCRIPTION_LIST_CTL;
	}
		return ORSView.DESCRIPTION_VIEW;
	}

	@Override
	protected DescriptionModel getModel() {
		return new DescriptionModel();
	}

}
