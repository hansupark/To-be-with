package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.admin.AdminLoginController;
import controller.apply.ApplyAcceptController;
import controller.apply.ApplyInsertController;
import controller.report.ReportAcceptController;
import controller.report.ReportInsertController;
import controller.signUpImage.SignUpImageInsertController;
import controller.travel.TravelIncreaseCountController;
import controller.travel.TravelSearchController;
import controller.user.UserApproveController;
import controller.user.UserDeleteController;
import controller.user.UserLoginController;


public class FrontController extends HttpServlet{

	HashMap<String,Controller> list = null;
	public void init(ServletConfig config) throws ServletException
	{
		list = new HashMap<String, Controller>();
		list.put("/travelSearch.do",new TravelSearchController());
		list.put("/travelIncreaseCount.do",new TravelIncreaseCountController());
		
		list.put("/reportInsert.do",new ReportInsertController());
		list.put("/reportApprove.do",new ReportAcceptController());
		
		list.put("/userLogin.do",new UserLoginController());
		list.put("/userDelete.do",new UserDeleteController());
		list.put("/userApprove.do",new UserApproveController());
		
		list.put("/applyAccept.do",new ApplyAcceptController());
		list.put("/applyInsert.do",new ApplyInsertController());
		
		list.put("/adminLogin.do",new AdminLoginController());
		
		list.put("/uploadimage.do", new SignUpImageInsertController());
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String url = request.getRequestURI(); 
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		System.out.println("path : " + path);
		Controller subController = list.get(path);	
		subController.execute(request, response);
	}
}
