package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.apply.ApplyInsertController;
import controller.travel.TravelSearchController;


public class FrontController extends HttpServlet{

	HashMap<String,Controller> list = null;
	public void init(ServletConfig config) throws ServletException
	{
		list = new HashMap<String, Controller>();
		list.put("/travelSearch.do",new TravelSearchController());
		list.put("/applyInsert.do",new ApplyInsertController());
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
