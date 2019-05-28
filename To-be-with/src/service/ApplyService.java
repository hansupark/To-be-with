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
		if(travel.getMax_Count() == travel.getCurrent_Count()) //해당 travel이 full인 경우
		{
			return 0;
		}
		return dao_apply.insertApply(vo);
	}
}
