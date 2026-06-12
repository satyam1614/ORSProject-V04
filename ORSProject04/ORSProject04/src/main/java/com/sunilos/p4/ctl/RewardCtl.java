package com.sunilos.p4.ctl;


import com.sunilos.p4.bean.RewardBean;
import com.sunilos.p4.model.RewardModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/RewardCtl")
public class RewardCtl extends BaseCtl<RewardBean, RewardModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("citizenName"))) {
			request.setAttribute("citizenName", PropertyReader.getValue("error.require", "Citizen Name"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("pointsEarned"))) {
			request.setAttribute("pointsEarned", PropertyReader.getValue("error.require", "Points Earned"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "Status"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("type"))) {
			request.setAttribute("type", PropertyReader.getValue("error.require", "Type"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected RewardBean populateBean(HttpServletRequest request) {

		RewardBean bean = new RewardBean();

		bean.setCitizenName(DataUtility.getString(request.getParameter("citizenName")));
		bean.setPointsEarned(DataUtility.getString(request.getParameter("pointsEarned")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));
		bean.setType(DataUtility.getString(request.getParameter("type")));

		populateDTO(bean, request);

		return bean;
	}


	@Override
	protected String getView() {
		return ORSView.REWARD_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.REWARD_CTL;
		}
		return ORSView.REWARD_VIEW;
	}
	

	@Override
	protected RewardModel getModel() {
		return new RewardModel();
	}
	
	

}

