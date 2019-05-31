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
	
	public int userLogin(UserVo vo)
	{
		int result = 0; //ȸ������ x
		UserVo compare = dao.SelectUser(vo);
		if(compare != null)
		{
			if(vo.getPassword().equals(compare.getPassword()))
			{
				result = compare.getUserNum(); //�α��� ����
			}
			else
			{
				result = -1; // ��й�ȣ Ʋ��
			}
		}
		
		return result;
	}
	
	public int userCreate(UserVo vo)
	{
		return dao.InsertUser(vo);
	}
	
	public UserVo selectUser(UserVo vo)
	{
		return dao.SelectUser(vo);
	}
	
	public UserVo selectUser_byPhone_Number(UserVo vo)
	{
		return dao.SelectUser_byPhoneNumber(vo);
	}
	
	public ArrayList<UserVo> selectUsers(UserVo vo)
	{
		return dao.selectUsers(vo);
	}
	
	public UserVo selectUser_byUserNum(UserVo vo)
	{
		return dao.SelectUser_byUserNum(vo);
	}

	public int userDelete(UserVo user) {
		return dao.deleteUser(user);
	}
}
