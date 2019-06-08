package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HttpUtil {

	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) {
	      try {
	         RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	         dispatcher.forward(request, response);
	         return;
	      } catch (Exception e) {
	         System.out.println("HttpUtil forward error 발생 : " + e);
	      }
	   }
	
	public static void Login(HttpServletRequest request, HttpServletResponse response) {
	      try {
	         if(request.getSession().getAttribute("LoginUserNum") == null)
	        	 forward(request, response, "login.jsp");         
	        return;
	      } catch (Exception e) {
	         System.out.println("HttpUtil forward error 발생 : " + e);
	      }
	   }
	
	public static void AdminLogin(HttpServletRequest request, HttpServletResponse response) {
	      try {
	         if(request.getSession().getAttribute("LoginAdmin") == null)
	        	 forward(request, response, "login.jsp");         
	        return;
	      } catch (Exception e) {
	         System.out.println("HttpUtil forward error 발생 : " + e);
	      }
	   }
}
