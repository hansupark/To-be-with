package controller.travel;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HttpUtil;
import service.ApplyService;
import service.UserService;
import vo.ApplyVo;
import vo.TravelVo;
import vo.UserVo;
import dao.TravelDao;
import service.TravelService;
public class TravelUpdateController implements Controller {
	
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
    
			TravelService service = TravelService.getService();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset = UTF-8"); 
			 int num = Integer.parseInt(req.getParameter("travelNum")); 
		     TravelVo modify = new TravelVo(); 	
		     modify.setTravelNum(num);
		     modify = service.getTravel(modify);    
		     modify.setCountry(req.getParameter("country"));
		     modify.setRegion(req.getParameter("region"));
		     modify.setMax_Count(Integer.parseInt(req.getParameter("max_Count")));
		     modify.setTitle(req.getParameter("title"));
		     modify.setContent(req.getParameter("content"));
		     modify.setTravelDate(req.getParameter("travelDate"));
		     int result = service.updateTravel(modify);		
			HttpUtil.forward(req,res,"resultList.jsp");
			return;
	}}

