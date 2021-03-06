package controller.apply;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.ApplyService;
import service.TravelService;
import service.UserService;
import vo.ApplyVo;
import vo.TravelVo;
import vo.UserVo;

public class ApplyDeleteController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset = UTF-8"); 
		
		ApplyService service = ApplyService.getService();
		int applyNum = Integer.parseInt(req.getParameter("applyNum"));
		int result = 0;
		int isApproved;
		ApplyVo vo = new ApplyVo();
		vo.setApplyNum(applyNum);
		vo = service.getApply(vo);
		isApproved = (vo.getIsApproved()) ? 1 : 0;
		
		result = service.applyDelete(vo);
		PrintWriter out = res.getWriter();
		result = (isApproved == 0) ? -1 : 1; 
		out.write("" + result);
		return;
	}

}
