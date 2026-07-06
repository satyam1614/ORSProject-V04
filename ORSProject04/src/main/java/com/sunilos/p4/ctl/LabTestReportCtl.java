package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.LabTestBean;
import com.sunilos.p4.model.LabTestModel;

public class LabTestReportCtl extends BaseReportCtl<LabTestBean> {

	@Override
	public String getView() {
		return ORSView.LABTEST_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		return "LABTEST_LIST_COMPILED_REPORT";
	}

	@Override
	public List<LabTestBean> getList() {
		
		LabTestModel model = new LabTestModel();
		List<LabTestBean> labTest = model.list();
		return labTest;
	}

}
