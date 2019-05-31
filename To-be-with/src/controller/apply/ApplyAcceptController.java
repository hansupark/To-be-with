package controller.apply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.ApplyService;
import service.TravelService;
import vo.ApplyVo;
import vo.TravelVo;

public class ApplyAcceptController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset = UTF-8");
		
		int applyNum = Integer.parseInt(req.getParameter("applyNum"));
		int result = 0;
		
		ApplyService service = ApplyService.getService();
		TravelService service_travel = TravelService.getService();
		
		ApplyVo apply = new ApplyVo();
		apply.setApplyNum(applyNum);
		apply = service.getApply(apply);		
						
		result = service.applyUpdate_Approved(apply);
		res.getWriter().write(""+result);
		return;
	}

}
