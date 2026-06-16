package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.ATMSystemBean;
import com.sunilos.p4.bean.BookBean;
import com.sunilos.p4.model.BookModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/BookCtl")
public class BookCtl extends BaseCtl<BookBean, BookModel> {
	
	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("title"))) {
			request.setAttribute("title", PropertyReader.getValue("error.require", "Title"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("author"))) {
			request.setAttribute("author", PropertyReader.getValue("error.require", "Authore"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("price"))) {
			request.setAttribute("price", PropertyReader.getValue("error.require", "Price"));
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("publisher"))) {
			request.setAttribute("publisher", PropertyReader.getValue("error.require", "Publisher"));
			pass = false;
		}
		
		return pass;
	}

	@Override
	protected BookBean populateBean(HttpServletRequest request) {

		BookBean bean = new BookBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setTitle(DataUtility.getString(request.getParameter("title")));
		bean.setAuthor(DataUtility.getString(request.getParameter("author")));
		bean.setPrice(DataUtility.getInt(request.getParameter("price")));
		bean.setPublisher(DataUtility.getString(request.getParameter("publisher")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.BOOK_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.BOOK_CTL;
		}
		return ORSView.BOOK_VIEW;
	}

	@Override
	protected BookModel getModel() {
		return new BookModel();
	}

}
