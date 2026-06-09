<%@page import="com.sunilos.p4.ctl.ATMSystemCtl"%>
<%@page import="com.sunilos.p4.ctl.BaseCtl"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@page import="com.sunilos.p4.util.DataUtility"%>
<%@page import="com.sunilos.p4.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="com.sunilos.p4.bean.ATMSystemBean"%>

<jsp:useBean id="bean" class="com.sunilos.p4.bean.ATMSystemBean"
	scope="request"></jsp:useBean>

<%
String _suc = ServletUtility.getSuccessMessage(request);
String _err = ServletUtility.getErrorMessage(request);
%>

<div class="container py-4" style="max-width: 580px;">
	<div class="card border-0 shadow-sm rounded-4 overflow-hidden">

		<div class="card-header text-white border-0 py-3 px-4"
			style="background: linear-gradient(135deg, #0d2137 0%, #1565c0 100%);">
			<h5 class="mb-0 fw-bold">
				<i class="bi bi-bookmark-star-fill me-2"></i>
				<%=bean.getId() > 0 ? "Edit ATM SYSTEM" : "Add ATM SYSTEM"%>
			</h5>
		</div>

		<div class="card-body px-4 py-4">

			<%
			if (_suc != null && !_suc.isEmpty()) {
			%>
			<div class="alert alert-success py-2">
				<i class="bi bi-check-circle-fill me-2"></i><%=_suc%></div>
			<%
			}
			%>
			<%
			if (_err != null && !_err.isEmpty()) {
			%>
			<div class="alert alert-danger py-2">
				<i class="bi bi-exclamation-triangle-fill me-2"></i><%=_err%></div>
			<%
			}
			%>

			<form action="<%=ORSView.ATMSYSTEM_CTL%>" method="POST">
				<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
					type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
				<input type="hidden" name="modifiedBy"
					value="<%=bean.getModifiedBy()%>"> <input type="hidden"
					name="createdDatetime"
					value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
				<input type="hidden" name="modifiedDatetime"
					value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

				<div class="mb-3">
					<label class="form-label fw-semibold">Bank Name <span
						class="text-danger">*</span></label> <input type="text" name="bankName"
						class="form-control" maxlength="100"
						value="<%=DataUtility.getStringData(bean.getBankName())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("bankName", request)%></div>
				</div>

				<div class="mb-3">
					<label class="form-label fw-semibold">Location <span
						class="text-danger">*</span></label> <input type="text"
						name="location" class="form-control" maxlength="200"
						value="<%=DataUtility.getStringData(bean.getLocation())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("location", request)%></div>
				</div>

				<div class="mb-3">
					<label class="form-label fw-semibold">Cash Available <span
						class="text-danger">*</span></label> <input type="text" name="cashAvailable" class="form-control"
						maxlength="200"
						value="<%=DataUtility.getStringData(bean.getCashAvailable())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("cashAvailable", request)%></div>
				</div>

				<div class="mb-3">
					<label class="form-label fw-semibold">Security Code <span
						class="text-danger">*</span></label> <input type="text" name="securityCode"
						class="form-control" maxlength="200"
						value="<%=DataUtility.getStringData(bean.getSecurityCode())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("securityCode", request)%></div>
				</div>

				<div class="d-flex gap-2 pt-2 border-top">
					<button type="submit" name="operation" value="<%=BaseCtl.OP_SAVE%>"
						class="btn btn-primary">
						<i class="bi bi-save me-1"></i> Save
					</button>
				</div>
			</form>
		</div>
	</div>
</div>