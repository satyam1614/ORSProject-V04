package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.MobileBean;
import com.sunilos.p4.model.MobileModel;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/ctl/MobileReportCtl")
public class MobileReportCtl extends BaseReportCtl<MobileBean> {

	@Override
	public String getView() {
		return ORSView.DESCRIPTION_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		return "DESCRIPTION_LIST_COMPILED_REPORT";
	}

	@Override
	public List<MobileBean> getList() {
		MobileModel model  = new MobileModel();
		List<MobileBean> mobile = model.list();
		return mobile;
	}

}
