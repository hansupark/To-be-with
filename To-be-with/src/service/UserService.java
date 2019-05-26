package service;

import java.util.ArrayList;

import dao.UserDao;
import vo.UserVo;

public class UserService {

	private UserDao dao = UserDao.getInstance();
	
	private static UserService service = new UserService();
	
	private UserService() {};
	
	public static UserService getInstance()
	{
		return service;
	}
	
	public UserVo userLogin(UserVo vo)
	{
		return dao.SelectUser(vo);
	}
	
	public int userCreate(UserVo vo)
	{
		int result = 0;
		ArrayList<UserVo> list = null;
		list = dao.selectUsers(vo);
		return result;
	}
}
