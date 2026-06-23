package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.ReportBean;
import com.sunilos.p4.model.ReportModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/ReportCtl")
public class ReportCtl extends BaseCtl<ReportBean, ReportModel> {
	
	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("type"))) {
			request.setAttribute("type", PropertyReader.getValue("error.require", "Type"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("generatedDate"))) {
			request.setAttribute("generatedDate", PropertyReader.getValue("error.require", "GeneratedDate"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("remarks"))) {
			request.setAttribute("remarks", PropertyReader.getValue("error.require", "Remarks"));
			pass = false;
		}


		return pass;
	}

	@Override
	protected ReportBean populateBean(HttpServletRequest request) {

		ReportBean bean = new ReportBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setType(DataUtility.getString(request.getParameter("type")));
		bean.setGeneratedDate(DataUtility.getDate(request.getParameter("generatedDate")));
		bean.setRemarks(DataUtility.getString(request.getParameter("remarks")));
		

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.REPORT_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.REPORT_LIST_CTL;
		}
		return ORSView.REPORT_VIEW;
	}

	@Override
	protected ReportModel getModel() {
		return new ReportModel();
	}

}
