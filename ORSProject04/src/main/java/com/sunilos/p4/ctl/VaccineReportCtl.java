package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.VaccineBean;
import com.sunilos.p4.model.VaccineModel;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/ctl/VaccineReportCtl")
public class VaccineReportCtl extends BaseReportCtl<VaccineBean> {

	@Override
	public String getView() {
		return ORSView.VACCINE_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		return "VACCINE_LIST_COMPILED_REPORT";
	}

	@Override
	public List<VaccineBean> getList() {
		VaccineModel model = new VaccineModel();
		List<VaccineBean> vaccine = model.list();
		return vaccine;
	}

}
