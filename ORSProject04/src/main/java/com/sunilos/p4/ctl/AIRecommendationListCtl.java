package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.AIRecommendationBean;
import com.sunilos.p4.bean.DescriptionBean;
import com.sunilos.p4.model.AIRecommendationModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/AIRecommendationListCtl")
public class AIRecommendationListCtl extends BaseListCtl<AIRecommendationBean, AIRecommendationModel> {
	
	@Override
	protected AIRecommendationBean populateBean(HttpServletRequest request) {

		AIRecommendationBean bean = new AIRecommendationBean();

		bean.setCode(DataUtility.getString(request.getParameter("code")));
		bean.setUserName(DataUtility.getString(request.getParameter("userName")));
		bean.setType(DataUtility.getString(request.getParameter("type")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.AIRECOMMENDATION_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.AIRECOMMENDATION_LIST_VIEW;
	}

	@Override
	protected AIRecommendationModel getModel() {
		return new AIRecommendationModel();
	}

}
