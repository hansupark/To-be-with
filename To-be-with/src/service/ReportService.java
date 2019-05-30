package service;



import java.util.ArrayList;
import dao.ReportDao;
import vo.ReportVo;

public class ReportService {

	private static ReportService service = new ReportService();
	
	private ReportService() {};
	
	private ReportDao dao = ReportDao.getInstance();
	
	public int insertReport(ReportVo vo)
	{
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
	
	public ArrayList<ReportVo> selectReports(ReportVo vo)
	{
		return dao.selectReports(vo);
	}
	
}
