package service;



import java.util.ArrayList;
import dao.ReportDao;
import vo.ReportVo;
import vo.TravelVo;

public class ReportService {

	private static ReportService service = new ReportService();
	
	private ReportService() {};
	
	public static ReportService getService()
	{
		return service;
	}
		
	private ReportDao dao = ReportDao.getInstance();
	
	private TravelService service_travel = TravelService.getService();
	
	public int insertReport(ReportVo vo)
	{
		int travelNum = vo.getObjectNum();
		TravelVo travel = new TravelVo();
		travel.setTravelNum(travelNum);
		travel = service_travel.getTravel(travel);
		System.out.println("travel's title = " + travel.getTitle());
		System.out.println("reportedUserNum : " + travel.getUserNum());
		vo.setReportedUserNum(travel.getUserNum());
		return dao.insertReport(vo);
	}
	
	public int updateReport(ReportVo vo)
	{
		return dao.updateReport(vo);
	}

	public int deleteReport(ReportVo vo)
	{
		return dao.deleteReport(vo);
	}
	
	public ReportVo selectReport(ReportVo vo)
	{
		return dao.selectReport(vo);
	}
	
	public ArrayList<ReportVo> selectReports_ByReporterNum(ReportVo vo)
	{
		return dao.selectReports_ByReporterNum(vo);
	}
	
	public ArrayList<ReportVo> selectReports(ReportVo vo)
	{
		return dao.selectReports(vo);
	}
	
}
