package controller.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class ReportInsertController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int reportNum = Integer.parseInt(req.getParameter("reportNum"));
		int reporterNum = Integer.parseInt(req.getParameter("reporterNum"));
		
	}

}
