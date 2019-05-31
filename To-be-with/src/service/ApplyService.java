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
	
	public ArrayList<ApplyVo> getApplyList_ByUserNum(ApplyVo vo) //���� �α��� �Ǿ��ִ� ������ ��ûapply�� return
	{
		ArrayList<ApplyVo> list = dao_apply.getApplyList_ByUserNum(vo);
		return list;
	}
	
	public ArrayList<ApplyVo> getApplyList_ByTravelNum(ApplyVo vo) //���� �α��� �Ǿ��ִ� ������ ��ûapply�� return
	{
		ArrayList<ApplyVo> list = dao_apply.getApplyList_ByTravelNum(vo);
		return list;
	}
	
	
	public int applyUpdate_Approved(ApplyVo vo) //���������� �޼ҵ�
	{
		int result = 0;
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
		
		TravelVo travel = new TravelVo();
		travel.setTravelNum(vo.getTravelNum());
		travel = service_travel.getTravel(travel);
		if(travel.getMax_Count() == travel.getCurrent_Count()) //�ش� travel�� full�� ���
		{
			return 0;
		}
		
		return dao_apply.insertApply(vo);
	}
	
}
