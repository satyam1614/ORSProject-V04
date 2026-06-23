package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.ReportBean;
import com.sunilos.p4.bean.VaccineBean;
import com.sunilos.p4.model.ReportModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/ReportListCtl")
public class ReportListCtl extends BaseListCtl<ReportBean, ReportModel> {
	
	@Override
	protected ReportBean populateBean(HttpServletRequest request) {
		
		ReportBean bean = new ReportBean();
		
		bean.setType(DataUtility.getString(request.getParameter("type")));
		bean.setGeneratedDate(DataUtility.getDate(request.getParameter("generatedDate")));
		bean.setRemarks(DataUtility.getString(request.getParameter("remarks")));
		
		
		populateDTO(bean, request);
		
		return bean;
	}
	

	@Override
	protected String getView() {
		return ORSView.REPORT_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.REPORT_LIST_VIEW;
	}

	@Override
	protected ReportModel getModel() {
		return new ReportModel();
	}

}
