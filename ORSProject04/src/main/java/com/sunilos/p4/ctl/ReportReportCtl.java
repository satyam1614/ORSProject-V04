package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.ReportBean;
import com.sunilos.p4.model.ReportModel;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/ctl/ReportReportCtl")
public class ReportReportCtl extends BaseReportCtl<ReportBean> {

	@Override
	public String getView() {
		return ORSView.REPORT_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		return "REPORT_LIST_COMPILED_REPORT";
	}

	@Override
	public List<ReportBean> getList() {
		
		ReportModel model = new ReportModel();
		List<ReportBean> report = model.list();
		return report;
	}
}
