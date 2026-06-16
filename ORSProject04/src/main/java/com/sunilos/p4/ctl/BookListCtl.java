package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.BookBean;
import com.sunilos.p4.model.BookModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/BookListCtl")
public class BookListCtl  extends BaseListCtl<BookBean, BookModel> {
	
	@Override
	protected BookBean populateBean(HttpServletRequest request) {
		
		BookBean bean = new BookBean();
		
		bean.setTitle(DataUtility.getString(request.getParameter("title")));
		bean.setAuthor(DataUtility.getString(request.getParameter("author")));
		bean.setPrice(DataUtility.getInt(request.getParameter("price")));
		bean.setPublisher(DataUtility.getString(request.getParameter("publisher")));
		
		return super.populateBean(request);
	}

	@Override
	protected String getView() {
		return ORSView.BOOK_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.BOOK_LIST_VIEW;
	}

	@Override
	protected BookModel getModel() {
		return new BookModel();
	}

}
