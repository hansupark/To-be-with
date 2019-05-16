package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HttpUtil {

	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) {
	      try {
	         RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	         dispatcher.forward(request, response);
	      } catch (Exception e) {
	         System.out.println("HttpUtil forward error 발생 : " + e);
	      }
	   }
}
