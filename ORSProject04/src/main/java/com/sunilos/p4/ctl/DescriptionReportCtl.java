package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.DescriptionBean;
import com.sunilos.p4.model.DescriptionModel;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/ctl/DescriptionReportCtl")
public class DescriptionReportCtl extends BaseReportCtl<DescriptionBean> {

	@Override
	public String getView() {
		return ORSView.DESCRIPTION_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		return "DESCRIPTION_LIST_COMPILED_REPORT";
	}

	@Override
	public List<DescriptionBean> getList() {
		DescriptionModel model = new DescriptionModel();
		List<DescriptionBean> description = model.list();
		return description;
	}

}
