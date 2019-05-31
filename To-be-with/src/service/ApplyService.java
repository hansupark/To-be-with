package service;

import java.util.ArrayList;

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
	
	public ApplyVo getApply(ApplyVo vo)
	{
		return dao_apply.getApply(vo);
	}
	public ArrayList<ApplyVo> getApplyList_ByUserNum(ApplyVo vo) //현재 로그인 되어있는 유저의 신청apply를 return
	{
		ArrayList<ApplyVo> list = dao_apply.getApplyList_ByUserNum(vo);
		return list;
	}
	
	public ArrayList<ApplyVo> getApplyList_ByTravelNum(ApplyVo vo) //현재 로그인 되어있는 유저의 신청apply를 return
	{
		ArrayList<ApplyVo> list = dao_apply.getApplyList_ByTravelNum(vo);
		return list;
	}
	
	
	public int applyUpdate_Approved(ApplyVo vo) //승인했을때 메소드
	{
		int result = 0;
		//해당 여행이 count가 max인지 검사
		TravelVo travel = new TravelVo();
		travel.setTravelNum(vo.getTravelNum());
		travel = service_travel.getTravel(travel);
		
		if(travel.getMax_Count() == travel.getCurrent_Count())
		{
			return result;
		}
		vo.setIsApproved(true); 
		result = dao_apply.updateApply(vo);
		return result;
	}
	
	public int applyDelete(ApplyVo vo)
	{
		int result = 0;
		result = dao_apply.deleteApply(vo);
		return result;
	}
	
	public int applyInsert(ApplyVo vo)
	{
		if(vo == null)
		{
			return 0;
		}
		TravelService service_travel = TravelService.getService();
		TravelVo travel = new TravelVo();
		travel.setTravelNum(vo.getTravelNum());
		
		travel = service_travel.getTravel(travel); //해당 동행을 가져옴		
		if(travel.getMax_Count() == travel.getCurrent_Count()) //해당 travel이 full인 경우
		{
			return 0;
		}
		
		
		//해당 유저가 해당 날짜에 신청을 했는지 검사
		ArrayList<ApplyVo> list_apply = dao_apply.getApplyList_ByUserNum(vo);
		for(ApplyVo a : list_apply)
		{
			TravelVo compare = new TravelVo();
			compare.setTravelNum(a.getTravelNum());
			compare = service_travel.getTravel(compare);
			if(compare.getTravelDate().equals(travel.getTravelDate()))
			{
				System.out.println("해당 날짜에 이미 동행 있음");
				return -1;
			}		
			
		}
		return dao_apply.insertApply(vo);
	}
	
}
