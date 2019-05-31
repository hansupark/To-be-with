package controller.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.ReportService;
import vo.ReportVo;

public class ReportInsertController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset = UTF-8");
		
		ReportService service = ReportService.getService();
		
		int result = 0;
		ReportVo report = new ReportVo();
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int reporterNum = Integer.parseInt(req.getParameter("reporterNum"));
		int objectNum = Integer.parseInt(req.getParameter("objectNum"));
		
		report.setTitle(title);
		report.setContent(content);
		report.setReporterNum(reporterNum);
		report.setObjectNum(objectNum);
		
		result = service.insertReport(report);
		
		res.getWriter().write(""+result);
		
		return;
	}

}
