package controller.travel;


import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HttpUtil;
import service.TravelService;
import vo.TravelVo;
import dao.TravelDao;

	public class TravelInsertController implements Controller {
		
		public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset = UTF-8");	
       
		String title = req.getParameter("title");
	    String content = req.getParameter("content");
	    String region = req.getParameter("region");
	    String country = req.getParameter("country");
	    String travelDate = req.getParameter("date");
	    int userNum= (int) req.getSession().getAttribute("LoginUserNum");
	    int max_Count = (int) req.getSession().getAttribute("max_Count");
        TravelDao Dao = TravelDao.getInstance();
	    TravelVo TravelVo = new TravelVo();
  
	    TravelVo.setTitle(title);
        TravelVo.setContent(content);
        TravelVo.setRegion(region);
        TravelVo.setCountry(country);
	     TravelVo.setTravelDate(travelDate);
		 TravelVo.setUserNum(userNum);
		 TravelVo.setMax_Count(max_Count);
         TravelService service = TravelService.getService();
         int result = service.insertTravel(TravelVo);
		 System.out.println(result);
		//res.sendRedirect("reseultList.do");
		HttpUtil.forward(req,res,"resultList.jsp");
		return;
	}
	
}

