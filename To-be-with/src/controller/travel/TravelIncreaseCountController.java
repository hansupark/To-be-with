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

public class TravelIncreaseCountController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		// TODO Auto-generated method stub
		int result = 0;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset = UTF-8"); 
		TravelService service = TravelService.getService();
		TravelVo vo = new TravelVo();
		vo.setTravelNum(Integer.parseInt(req.getParameter("travelNum")));
		vo = service.getTravel(vo);
		vo.setCurrent_Count(vo.getCurrent_Count() + 1);
		result = service.updateTravel(vo);
		
		res.getWriter().write("" +result);
		return;
	}

}
