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

public class TravelSearchController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset = UTF-8"); 
		TravelService service = TravelService.getService();
		ArrayList<TravelVo> list = new ArrayList<TravelVo>();
		
		TravelVo vo = new TravelVo();
		String country = req.getParameter("country");
		String region = req.getParameter("region");		
		String travelDate = req.getParameter("travelDate");
		
		vo.setCountry(country);
		vo.setRegion(region);
		vo.setTravelDate(travelDate);
		
		list = service.getTravelLists(vo);
		req.setAttribute("resultList",list);
		/*
		 * StringBuffer result = new StringBuffer(""); result.append("{\"result\" : [");
		 * for(int x = list.size() - 1 ; x >= 0 ; x--) {
		 * result.append(String.format("[{\"value\" : %d},{\"value\" : %d}" +
		 * ",{\"value\" : \"%s\"},{\"value\" : \"%s\"},{\"value\" : \"%s\"}," +
		 * "{\"value\" : %d},{\"value\" : %d}]",list.get(x).getTravelNum(),list.get(x).
		 * getUserNum()
		 * ,list.get(x).getCountry(),list.get(x).getRegion(),list.get(x).getTravelDate()
		 * ,list.get(x).getMax_Count(),list.get(x).getCurrent_Count()));
		 * System.out.println(list.get(x).getTravelDate()); if(x != 0) {
		 * result.append(","); } } result.append("]}");
		 * System.out.println(result.toString());
		 * res.getWriter().write(result.toString());
		 */
		HttpUtil.forward(req, res, "resultList.jsp");
		return;
	}

}
