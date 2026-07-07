package com.sunilos.p4.ctl;

/**
 * Contains ORS View and Controller URI
 * 
 * @author Satyam Yadav
 * @version 1.0
 * @Copyright (c) Rays EdTech
 */

public interface ORSView {

	public String APP_CONTEXT = "/ORSProject04";

	public String PAGE_FOLDER = "/jsp";

	public String JAVA_DOC_VIEW = APP_CONTEXT + "/doc/index.html";

	public String ERROR_VIEW = PAGE_FOLDER + "/MarksheetListView.jsp";

	public String MARKSHEET_VIEW = PAGE_FOLDER + "/MarksheetView.jsp";

	public String MARKSHEET_LIST_VIEW = PAGE_FOLDER + "/MarksheetListView.jsp";
	public String GET_MARKSHEET_VIEW = PAGE_FOLDER + "/GetMarksheetView.jsp";
	public String USER_VIEW = PAGE_FOLDER + "/UserView.jsp";
	public String USER_LIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
	public String COLLEGE_VIEW = PAGE_FOLDER + "/CollegeView.jsp";
	public String COLLEGE_LIST_VIEW = PAGE_FOLDER + "/CollegeListView.jsp";
	public String STUDENT_VIEW = PAGE_FOLDER + "/StudentView.jsp";
	public String STUDENT_LIST_VIEW = PAGE_FOLDER + "/StudentListView.jsp";
	public String ROLE_VIEW = PAGE_FOLDER + "/RoleView.jsp";
	public String ROLE_LIST_VIEW = PAGE_FOLDER + "/RoleListView.jsp";
	public String COURSE_VIEW = PAGE_FOLDER + "/CourseView.jsp";
	public String COURSE_LIST_VIEW = PAGE_FOLDER + "/CourseListView.jsp";
	public String SUBJECT_VIEW = PAGE_FOLDER + "/SubjectView.jsp";
	public String SUBJECT_LIST_VIEW = PAGE_FOLDER + "/SubjectListView.jsp";
	public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/UserRegistrationView.jsp";
	public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
	public String WELCOME_VIEW = PAGE_FOLDER + "/Welcome.jsp";
	public String CHANGE_PASSWORD_VIEW = PAGE_FOLDER + "/ChangePasswordView.jsp";
	public String MY_PROFILE_VIEW = PAGE_FOLDER + "/MyProfileView.jsp";
	public String FORGET_PASSWORD_VIEW = PAGE_FOLDER + "/ForgetPasswordView.jsp";
	public String MARKSHEET_MERIT_LIST_VIEW = PAGE_FOLDER + "/MarksheetMeritListView.jsp";
	public String REWARD_VIEW = PAGE_FOLDER + "/RewardView.jsp";
	
	public String ERROR_CTL = "/ctl/MarksheetCtl";

	public String MARKSHEET_CTL = APP_CONTEXT + "/ctl/MarksheetCtl";
	public String MARKSHEET_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetListCtl";
	public String USER_CTL = APP_CONTEXT + "/ctl/UserCtl";
	public String USER_LIST_CTL = APP_CONTEXT + "/ctl/UserListCtl";
	public String COLLEGE_CTL = APP_CONTEXT + "/ctl/CollegeCtl";
	public String COLLEGE_LIST_CTL = APP_CONTEXT + "/ctl/CollegeListCtl";
	public String STUDENT_CTL = APP_CONTEXT + "/ctl/StudentCtl";
	public String STUDENT_LIST_CTL = APP_CONTEXT + "/ctl/StudentListCtl";
	public String ROLE_CTL = APP_CONTEXT + "/ctl/RoleCtl";
	public String ROLE_LIST_CTL = APP_CONTEXT + "/ctl/RoleListCtl";
	public String COURSE_CTL = APP_CONTEXT + "/ctl/CourseCtl";
	public String COURSE_LIST_CTL = APP_CONTEXT + "/ctl/CourseListCtl";
	public String SUBJECT_CTL = APP_CONTEXT + "/ctl/SubjectCtl";
	public String SUBJECT_LIST_CTL = APP_CONTEXT + "/ctl/SubjectListCtl";
	public String USER_REGISTRATION_CTL = APP_CONTEXT + "/UserRegistrationCtl";
	public String LOGIN_CTL = APP_CONTEXT + "/LoginCtl";
	public String WELCOME_CTL = APP_CONTEXT + "/WelcomeCtl";
	public String LOGOUT_CTL = APP_CONTEXT + "/LoginCtl";
	public String GET_MARKSHEET_CTL = APP_CONTEXT + "/ctl/GetMarksheetCtl";
	public String CHANGE_PASSWORD_CTL = APP_CONTEXT + "/ctl/ChangePasswordCtl";
	public String MY_PROFILE_CTL = APP_CONTEXT + "/ctl/MyProfileCtl";
	public String FORGET_PASSWORD_CTL = APP_CONTEXT + "/ForgetPasswordCtl";
	public String MARKSHEET_MERIT_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetMeritListCtl";

	public String FACULTY_VIEW = PAGE_FOLDER + "/FacultyView.jsp";
	public String FACULTY_LIST_VIEW = PAGE_FOLDER + "/FacultyListView.jsp";
	public String FACULTY_CTL = APP_CONTEXT + "/ctl/FacultyCtl";
	public String FACULTY_LIST_CTL = APP_CONTEXT + "/ctl/FacultyListCtl";

	public String STUDENT_REPORT_CTL = APP_CONTEXT + "/ctl/StudentReportCtl";
	public String COLLEGE_REPORT_CTL = APP_CONTEXT + "/ctl/CollegeReportCtl";
	public String USER_REPORT_CTL = APP_CONTEXT + "/ctl/UserReportCtl";
	public String ROLE_REPORT_CTL = APP_CONTEXT + "/ctl/RoleReportCtl";
	public String COURSE_REPORT_CTL = APP_CONTEXT + "/ctl/CourseReportCtl";
	public String SUBJECT_REPORT_CTL = APP_CONTEXT + "/ctl/SubjectReportCtl";
	public String MARKSHEET_REPORT_CTL = APP_CONTEXT + "/ctl/MarksheetReportCtl";
	public String FACULTY_REPORT_CTL = APP_CONTEXT + "/ctl/FacultyReportCtl";
	
	
	public String REWARD_CTL = APP_CONTEXT + "/ctl/RewardCtl";

	public String COURSE_REPORT_VIEW = "/reports/CourseListReport.jrxml";
	public String STUDENT_REPORT_VIEW = "/reports/StudentListReport.jrxml";
	public String COLLEGE_REPORT_VIEW = "/reports/CollegeListReport.jrxml";
	public String USER_REPORT_VIEW = "/reports/UserListReport.jrxml";
	public String ROLE_REPORT_VIEW = "/reports/RoleListReport.jrxml";
	public String SUBJECT_REPORT_VIEW = "/reports/SubjectListReport.jrxml";
	public String MARKSHEET_REPORT_VIEW = "/reports/MarksheetListReport.jrxml";
	public String FACULTY_REPORT_VIEW = "/reports/FacultyListReport.jrxml";
	
	public String PRODUCT_VIEW = PAGE_FOLDER + "/ProductView.jsp";
	public String PRODUCT_LIST_VIEW = PAGE_FOLDER + "/ProductListView.jsp";
	public String PRODUCT_CTL = APP_CONTEXT + "/ctl/ProductCtl";
	public String PRODUCT_LIST_CTL = APP_CONTEXT + "/ctl/ProductListCtl";
	
	public String DELIVERY_VIEW = PAGE_FOLDER + "/DeliveryView.jsp";
	public String DELIVERY_LIST_VIEW = PAGE_FOLDER + "/DeliveryListView.jsp";
	public String DELIVERY_CTL = APP_CONTEXT + "/ctl/DeliveryCtl";
	public String DELIVERY_LIST_CTL = APP_CONTEXT + "/ctl/DeliveryListCtl";
	
	public String ATMSYSTEM_VIEW = PAGE_FOLDER + "/ATMSystemView.jsp";
	public String ATMSYSTEM_LIST_VIEW = PAGE_FOLDER + "/ATMSystemListView.jsp";
	public String ATMSYSTEM_CTL = APP_CONTEXT + "/ctl/ATMSystemCtl";
	public String ATMSYSTEM_LIST_CTL = APP_CONTEXT + "/ctl/ATMSystemListCtl";
	
	public String BOOK_VIEW = PAGE_FOLDER + "/BookView.jsp";
	public String BOOK_LIST_VIEW = PAGE_FOLDER + "/BookListView.jsp";
	public String BOOK_CTL = APP_CONTEXT + "/ctl/BookCtl";
	public String BOOK_LIST_CTL = APP_CONTEXT + "/ctl/BookListCtl";
	
	public String DESCRIPTION_VIEW = PAGE_FOLDER + "/DescriptionView.jsp";
	public String DESCRIPTION_LIST_VIEW = PAGE_FOLDER + "/DescriptionListView.jsp";
	public String DESCRIPTION_CTL = APP_CONTEXT + "/ctl/DescriptionCtl";
	public String DESCRIPTION_LIST_CTL = APP_CONTEXT + "/ctl/DescriptionListCtl";
	public String DESCRIPTION_REPORT_CTL = APP_CONTEXT + "/ctl/DescriptionReportCtl";
	public String DESCRIPTION_REPORT_VIEW = "/reports/DescriptionListReport.jrxml";
	
	public String MOBILE_VIEW = PAGE_FOLDER + "/MobileView.jsp";
	public String MOBILE_LIST_VIEW = PAGE_FOLDER + "/MobileListView.jsp";
	public String MOBILE_CTL = APP_CONTEXT + "/ctl/MobileCtl";
	public String MOBILE_LIST_CTL = APP_CONTEXT + "/ctl/MobileListCtl";
	public String MOBILE_REPORT_CTL = APP_CONTEXT + "/ctl/MobileReportCtl";
	public String MOBILE_REPORT_VIEW = "/reports/MobileListReport.jrxml";
	
	public String VACCINE_VIEW = PAGE_FOLDER + "/VaccineView.jsp";
	public String VACCINE_LIST_VIEW = PAGE_FOLDER + "/VaccineListView.jsp";
	public String VACCINE_CTL = APP_CONTEXT + "/ctl/VaccineCtl";
	public String VACCINE_LIST_CTL = APP_CONTEXT + "/ctl/VaccineListCtl";
	public String VACCINE_REPORT_CTL = APP_CONTEXT + "/ctl/VaccineReportCtl";
	public String VACCINE_REPORT_VIEW = "/reports/VaccineListReport.jrxml";
	
	public String REPORT_VIEW = PAGE_FOLDER + "/ReportView.jsp";
	public String REPORT_LIST_VIEW = PAGE_FOLDER + "/ReportListView.jsp";
	public String REPORT_CTL = APP_CONTEXT + "/ctl/ReportCtl";
	public String REPORT_LIST_CTL = APP_CONTEXT + "/ctl/ReportListCtl";
	public String REPORT_REPORT_CTL = APP_CONTEXT + "/ctl/ReportReportCtl";
	public String REPORT_REPORT_VIEW = "/reports/ReportListReport.jrxml";
	
	public String LABTEST_VIEW = PAGE_FOLDER + "/LabTestView.jsp";
	public String LABTEST_LIST_VIEW = PAGE_FOLDER + "/LabTestListView.jsp";
	public String LABTEST_CTL = APP_CONTEXT + "/ctl/LabTestCtl";
	public String LABTEST_LIST_CTL = APP_CONTEXT + "/ctl/LabTestListCtl";
	public String LABTEST_REPORT_CTL = APP_CONTEXT + "/ctl/LabTestReportCtl";
	public String LABTEST_REPORT_VIEW = "/reports/LabTestListReport.jrxml";
	
	
}
