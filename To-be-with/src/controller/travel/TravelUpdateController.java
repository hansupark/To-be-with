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
		
		int num = Integer.parseInt(req.getParameter("travelNum")); // ������ �Խñ��� ��ȣ�� �޾ƿ´�. ��� ���� �־�� �� �� �ʹ�..��§ �ǰ�..
		     TravelVo modify = new TravelVo(); 	
		      modify.setContent("numodim");
		      modify.setTitle("num");
		      
		    int result = service.updateTravel(modify);      
		     
		    System.out.println(result);
		
			HttpUtil.forward(req,res,"resultList.jsp");
		            
    
	}}

