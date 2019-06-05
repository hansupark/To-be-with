package controller.travel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.ApplyService;
import service.UserService;
import vo.ApplyVo;
import vo.TravelVo;
import vo.UserVo;
import dao.TravelDao;
import service.TravelService;

public class TravelDeleteController  implements Controller 
{	
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  TravelService service = TravelService.getService();
		  req.setCharacterEncoding("utf-8");
	      res.setContentType("texxt/html;charset=utf-8");
	      
	      int Travellist = Integer.parseInt(req.getParameter("travelNum"));
	      int result = 0;
	      
	      TravelVo travel = new TravelVo();
	      travel.setTravelNum(Travellist);
	      result = service.deleteTravel(travel);
	      
	      res.getWriter().write(""+result);
	      return;
	}
			 
}

