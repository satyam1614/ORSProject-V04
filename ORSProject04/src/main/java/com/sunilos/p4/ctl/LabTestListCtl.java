package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.LabTestBean;
import com.sunilos.p4.bean.ReportBean;
import com.sunilos.p4.model.LabTestModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/LabTestListCtl")
public class LabTestListCtl extends BaseListCtl<LabTestBean, LabTestModel> {
	
	@Override
	protected LabTestBean populateBean(HttpServletRequest request) {
		
		LabTestBean bean = new LabTestBean();
		
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setCost(DataUtility.getInt(request.getParameter("cost")));
		bean.setTestDate(DataUtility.getDate(request.getParameter("testDate")));
		
		populateDTO(bean, request);
		
		return bean;
	}
	


	@Override
	protected String getView() {
		return ORSView.LABTEST_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.LABTEST_LIST_VIEW;
	}

	@Override
	protected LabTestModel getModel() {
		return new LabTestModel();
	}

}
