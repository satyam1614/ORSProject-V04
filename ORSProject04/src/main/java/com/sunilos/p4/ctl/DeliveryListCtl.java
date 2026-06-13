package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.DeliveryBean;
import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.model.DeliveryModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/DeliveryListCtl")
public class DeliveryListCtl extends BaseListCtl<DeliveryBean, DeliveryModel> {
	
	@Override
	protected DeliveryBean populateBean(HttpServletRequest request) {
		
		DeliveryBean bean = new DeliveryBean();
		
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
		return ORSView.DELIVERY_LIST_VIEW;
	}

	@Override
	protected DeliveryModel getModel() {
		return new DeliveryModel();
	}

}
