package service;

import dao.AdminDao;
import vo.AdminVo;

public class AdminService {

	private static AdminService service = new AdminService();
	
	private AdminService() {};
	
	public static AdminService getService()
	{
		return service;
	}
	
	private AdminDao dao = AdminDao.getInstance();
	
	public int LoginAdmin(AdminVo vo)
	{
		AdminVo compare = dao.selectAdmin(vo);
		if(compare != null)
		{
			if(compare.getPw().equals(vo.getPw()))
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
		else
		{
			return 0;
		}
	}
}
