package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.DeliveryBean;
import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.model.DeliveryModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/DeliveryCtl")
public class DeliveryCtl extends BaseCtl<DeliveryBean, DeliveryModel> {
	
	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("deliveryBoyName"))) {
			request.setAttribute("deliveryBoyName", PropertyReader.getValue("error.require", "Delivery Boy Name"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("address"))) {
			request.setAttribute("address", PropertyReader.getValue("error.require", "Address"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("deliveryDate"))) {
			request.setAttribute("deliveryDate", PropertyReader.getValue("error.require", "Delivery Date"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "Status"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected DeliveryBean populateBean(HttpServletRequest request) {

		DeliveryBean bean = new DeliveryBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setDeliveryBoyName(DataUtility.getString(request.getParameter("deliveryBoyName")));
		bean.setAddress(DataUtility.getString(request.getParameter("address")));
		bean.setDeliveryDate(DataUtility.getDate(request.getParameter("deliveryDate")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.DELIVERY_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.DELIVERY_LIST_CTL;
		}
		return ORSView.DELIVERY_VIEW;
	}


	@Override
	protected DeliveryModel getModel() {
		return new DeliveryModel();
	}

}
