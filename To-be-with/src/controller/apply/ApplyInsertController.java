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

public class ApplyInsertController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset = UTF-8"); 
		
		ApplyService service = ApplyService.getService();
		int travelNum = Integer.parseInt(req.getParameter("travelNum"));
		int userNum = Integer.parseInt(req.getParameter("userNum"));
		int result = 0;
		
		ApplyVo vo = new ApplyVo();
		vo.setTravelNum(travelNum);
		vo.setUserNum(userNum);
		result = service.applyInsert(vo);
		
		PrintWriter out = res.getWriter();
		out.write("" + result);
		return;
	}

}
