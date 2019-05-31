package service;

import java.util.ArrayList;

import dao.TravelDao;
import vo.TravelVo;

public class TravelService {

	private static TravelService service = new TravelService();
	
	private TravelService() {};
	
	private TravelDao dao = TravelDao.getInstance();
	
	public static TravelService getService()
	{
		return service;
	}
	
	public TravelVo getTravel(TravelVo travel)
	{
		return dao.getTravel(travel);
	}
	
	public ArrayList<TravelVo> getTravelLists(TravelVo travel)
	{
		return dao.getTravelList(travel);
	}
	
	public int insertTravel(TravelVo travel)
	{
		return dao.insertTravel(travel);
	}
	
	public int upadteTravel(TravelVo travel)
	{
		return dao.updateTravel(travel);
	}
	
	public int deleteTravel(TravelVo travel)
	{
		return dao.deleteTravel(travel);
	}
}
