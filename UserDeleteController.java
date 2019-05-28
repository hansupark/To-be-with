package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dao.UserDao;
import vo.UserVo;

public class UserDeleteController implements Controller{

	@Override/**�Ѽ��� ���� ¥���� �ڵ�� userdelete.do�� �ҷ����� �� �����Ѵ� ���µ�
	Ȥ�� ȸ������ ������ �ǰ� �ϰ� �� �Ÿ� ���� ¥���� �� ������ ������ **/
	/**���� ���� ���� ¥���ٸ� ���� ��� ��..�̾�..**/
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nextpage = null;
		req.setCharacterEncoding("utf-8");
		res.setContentType("texxt/html;charset=utf-8");
		String action = req.getPathInfo();
		
		// ȸ�� �̸����� sql������ ������ ���̺��� ȸ�� ������ ������ ����.
		if (action== null || action.equals("/DeleteUser.do")) { 
			String email  = req.getParameter("email"); //������ ȸ�� �̸����� �޾ƿ´�
		   UserVo Vo = new UserVo();
			UserDao.DeleteUser(email); //dao �κ��� ���� ������ �� �� �� ���� !!!!!!!!!!!! �װſ� ���� �� �ڵ带 �ٲ��� 
			req.setAttribute("msg","deleted"); // ���� ������ ȸ�� ���â���� ���� �۾� �Ϸ� �޼��� ����
			nextpage= "/member/listMembers.do"; // ���� ���� �ȵ� ȸ�� ���â�� ����.
		}else
		{
			ArrayList memberList = UserDao.listMembers(); // userdao�� ȸ�� list�� ���� ������ �� �Ű��� ȸ�� ���â.. ���ϴ� ���� ��,,
			req.Attribute("memberList",memberList);
			nextPage= "/���� ����";
		}
		RequestDispatcher dispatch = req.getRequestDispatcher(nextpage);
		dispatch.forward(req, res);
	}

}

