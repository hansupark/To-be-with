package service;

import dao.ApplyDao;
import dao.TravelDao;
import vo.ApplyVo;
import vo.TravelVo;

public class ApplyService {

	private ApplyDao dao_apply = ApplyDao.getInstance();
	
	private TravelService service_travel = TravelService.getService();
	
	private static ApplyService service = new ApplyService();
	
	private ApplyService() {};
	
	public static ApplyService getService()
	{
		return service;
	}
	
	public int applyInsert(ApplyVo vo)
	{
		if(vo == null)
		{
			return 0;
		}
		
		TravelVo travel = new TravelVo();
		travel.setTravelNum(vo.getTravelNum());
		travel = service_travel.getTravel(travel);
		
		return 1;
	}
}
