package controller.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.ReportService;
import service.TravelService;
import vo.ReportVo;
import vo.TravelVo;

public class ReportAcceptController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset = UTF-8");
	
		TravelService service = TravelService.getService();
		
		int result = 0;
		ReportVo report = new ReportVo();
		int objectNum = Integer.parseInt(req.getParameter("objectNum"));
		TravelVo travel = new TravelVo();
		travel.setTravelNum(objectNum);
		result = service.deleteTravel(travel);
		
		res.getWriter().write(""+result);
		
		return;
	}

}
