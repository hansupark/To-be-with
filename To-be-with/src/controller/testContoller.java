package controller;

import java.sql.Date;
import java.util.ArrayList;

import dao.TravelDao;
import vo.TravelVo;

public class testContoller {	
	// 컨트롤러 테스트 할수 있는 클래스
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<TravelVo> list;
		TravelDao dao = TravelDao.getInstance();
		TravelVo vo = new TravelVo();
		vo.setCountry("대한민국");
		vo.setRegion("서울");
		//vo.setTravelDate(new Date(2019,05,18));
		//System.out.println((new Date(2019,05,18)).toString());
		list = dao.getTravelList(vo);
		for(TravelVo travel : list)
		{
			System.out.println("country : " + travel.getCountry() + " region : "
		+ travel.getRegion() + " Date : " + travel.getTravelDate());
		}
	}

}
