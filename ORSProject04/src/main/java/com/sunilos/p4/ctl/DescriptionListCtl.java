package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.DescriptionBean;
import com.sunilos.p4.model.DescriptionModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/DescriptionListCtl")
public class DescriptionListCtl extends BaseListCtl<DescriptionBean, DescriptionModel> {

	@Override
	protected DescriptionBean populateBean(HttpServletRequest request) {

		DescriptionBean bean = new DescriptionBean();

		bean.setModuleName(DataUtility.getString(request.getParameter("moduleName")));
		bean.setTechnology(DataUtility.getString(request.getParameter("technology")));
		bean.setDeveloperName(DataUtility.getString(request.getParameter("developerName")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.DESCRIPTION_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.DESCRIPTION_LIST_VIEW;
	}

	@Override
	protected DescriptionModel getModel() {
		return new DescriptionModel();
	}

}
