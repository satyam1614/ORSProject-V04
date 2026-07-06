package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.LabTestBean;
import com.sunilos.p4.model.LabTestModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/LabTestCtl")
public class LabTestCtl extends BaseCtl<LabTestBean, LabTestModel> {
	
	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", "Name"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("cost"))) {
			request.setAttribute("cost", PropertyReader.getValue("error.require", "Cost"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("testDate"))) {
			request.setAttribute("testDate", PropertyReader.getValue("error.require", "TestDate"));
			pass = false;
		}


		return pass;
	}

	@Override
	protected LabTestBean populateBean(HttpServletRequest request) {

		LabTestBean bean = new LabTestBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setCost(DataUtility.getInt(request.getParameter("cost")));
		bean.setTestDate(DataUtility.getDate(request.getParameter("testDate")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.LABTEST_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.LABTEST_LIST_CTL;
		}
		return ORSView.LABTEST_VIEW;
	}

	@Override
	protected LabTestModel getModel() {
		return new LabTestModel();
	}

}
