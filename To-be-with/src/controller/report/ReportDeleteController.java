package controller.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.ReportService;
import vo.ReportVo;

public class ReportDeleteController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset = UTF-8");
		
		System.out.println("report delete ½ÇÇà");
		ReportService service = ReportService.getService();
		int result = 0;
		int reportNum = Integer.parseInt(req.getParameter("reportNum"));
		ReportVo report = new ReportVo();
		report.setReportNum(reportNum);
		
		
		result = service.deleteReport(report);
		
		res.getWriter().write(""+result);
		
		return;
	}

}
