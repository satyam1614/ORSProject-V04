package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.AIRecommendationBean;
import com.sunilos.p4.model.AIRecommendationModel;

import jakarta.servlet.annotation.WebServlet;
@WebServlet(("/ctl/AIRcommendationReportCtl"))
public class AIRecommendationReportCtl extends BaseReportCtl<AIRecommendationBean>{

	@Override
	public String getView() {
		return ORSView.AIRECOMMENDATION_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		return "AIRECOMMENDATION_LIST_COMPILED_REPORT";
	}

	@Override
	public List<AIRecommendationBean> getList() {
		AIRecommendationModel model = new AIRecommendationModel();
		List<AIRecommendationBean> airecommendation  = model.list();
		return airecommendation;
	}

}
