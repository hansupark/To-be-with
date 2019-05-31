package controller.travel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import service.ApplyService;
import service.TravelService;
import vo.ApplyVo;
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
		    
		
	       TravelDao Dao = TravelDao.getInstance();
		   TravelVo TravelVo = new TravelVo();
	  
		    TravelVo.setTitle(title);
	        TravelVo.setContent(content);
	        TravelVo.setRegion(region);
	        TravelVo.setCountry(country);
	        
		  //TravelDao.setId(sessionID);

		int Result = Dao.insertTravel(TravelVo);
		System.out.println(Result);
		res.sendRedirect("reseultList.do");
	}
	
}

